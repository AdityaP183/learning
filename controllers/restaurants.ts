import type { Request, Response } from "express";
import { nanoid } from "nanoid";
import { initializeRedis } from "../client.js";
import type { Restaurant } from "../schemas/restaurants.js";
import type { Review } from "../schemas/reviews.js";
import {
	cuisineKey,
	cuisinesKey,
	restaurantCuisineKeyById,
	restaurantKeyById,
	restaurantsByRatingKey,
	reviewDetailsKeyById,
	reviewKeyById,
} from "../utils/keys.js";
import { errorResponse, successResponse } from "../utils/responses.js";

export const createRestaurant = async (req: Request, res: Response) => {
	const data = req.body as Restaurant;
	const client = await initializeRedis();

	const id = nanoid();
	const restaurantKey = restaurantKeyById(id);
	const hashData = {
		id,
		name: data.name,
		location: data.location,
	};
	await Promise.all([
		...data.cuisines.map((cuisine) =>
			Promise.all([
				client.sAdd(cuisinesKey, cuisine),
				client.sAdd(cuisineKey(cuisine), id),
				client.sAdd(restaurantCuisineKeyById(id), cuisine),
			])
		),
		client.hSet(restaurantKey, hashData),
		client.zAdd(restaurantsByRatingKey, {
			score: 0,
			value: id,
		}),
	]);

	return successResponse(res, hashData, "Added new restaurant");
};

export const getRestaurants = async (req: Request, res: Response) => {
	const { page = 1, limit = 10 } = req.query;
	const start = (Number(page) - 1) * Number(limit);
	const end = start + Number(limit);

	const client = await initializeRedis();
	const restaurantIds = await client.zRange(
		restaurantsByRatingKey,
		start,
		end,
		{
			REV: true,
		}
	);
	const restaurants = await Promise.all(
		restaurantIds.map((id) => client.hGetAll(restaurantKeyById(id)))
	);
	return successResponse(res, restaurants);
};

export const getRestaurantById = async (
	req: Request<{ restaurantId: string }>,
	res: Response
) => {
	const { restaurantId } = req.params;

	const client = await initializeRedis();
	const restaurantKey = restaurantKeyById(restaurantId);

	const [_, restaurant, cuisines] = await Promise.all([
		client.hIncrBy(restaurantKey, "viewCount", 1),
		client.hGetAll(restaurantKey),
		client.sMembers(restaurantCuisineKeyById(restaurantId)),
	]);

	return successResponse(res, { ...restaurant, cuisines });
};

export const createRestaurantReview = async (
	req: Request<{ restaurantId: string }>,
	res: Response
) => {
	const { restaurantId } = req.params;
	const data = req.body as Review;

	const client = await initializeRedis();

	const reviewId = nanoid();
	const reviewKey = reviewKeyById(restaurantId);
	const reviewDetailsKey = reviewDetailsKeyById(reviewId);
	const restaurantKey = restaurantKeyById(restaurantId);

	const reviewData = {
		id: reviewId,
		...data,
		timestamp: Date.now(),
		restaurantId,
	};

	const [reviewCount, _, totalStars] = await Promise.all([
		client.lPush(reviewKey, reviewId),
		client.hSet(reviewDetailsKey, reviewData),
		client.hIncrByFloat(restaurantKey, "totalStars", data.rating),
	]);

	const averageRating = Number(
		(parseFloat(totalStars) / reviewCount).toFixed(1)
	);
	await Promise.all([
		client.zAdd(restaurantsByRatingKey, {
			score: averageRating,
			value: restaurantId,
		}),
		client.hSet(restaurantKey, "avgStars", averageRating),
	]);

	return successResponse(res, reviewData, "Added new review");
};

export const getRestaurantReviews = async (
	req: Request<{ restaurantId: string }>,
	res: Response
) => {
	const { restaurantId } = req.params;
	const { page = 1, limit = 10 } = req.query;

	const start = (Number(page) - 1) * Number(limit);
	const end = start + Number(limit) - 1;

	const client = await initializeRedis();
	const reviewKey = reviewKeyById(restaurantId);

	const reviewIds = await client.lRange(reviewKey, start, end);
	const reviews = await Promise.all(
		reviewIds.map((id) => client.hGetAll(reviewDetailsKeyById(id)))
	);

	return successResponse(res, reviews);
};

export const deleteRestaurantReview = async (
	req: Request<{
		restaurantId: string;
		reviewId: string;
	}>,
	res: Response
) => {
	const { restaurantId, reviewId } = req.params;

	const client = await initializeRedis();

	const reviewKey = reviewKeyById(restaurantId);
	const reviewDetailsKey = reviewDetailsKeyById(reviewId);

	const [removeResult, deleteResult] = await Promise.all([
		client.lRem(reviewKey, 0, reviewId),
		client.del(reviewDetailsKey),
	]);

	if (removeResult === 0 && deleteResult === 0) {
		return errorResponse(res, 404, "Review not found");
	}

	return successResponse(res, reviewId, "Review deleted");
};
