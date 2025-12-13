import type { Request, Response } from "express";
import { nanoid } from "nanoid";
import { initializeRedis } from "../client.js";
import type { Restaurant } from "../schemas/restaurants.js";
import type { Review } from "../schemas/reviews.js";
import {
	restaurantKeyById,
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
	const addResult = await client.hSet(restaurantKey, hashData);

	console.log("Added: ", addResult);

	return successResponse(res, hashData, "Added new restaurant");
};

export const getRestaurants = async (req: Request, res: Response) => {
	const client = await initializeRedis();
	const keys = await client.keys("redis:restaurants:*");
	const restaurants = await Promise.all(
		keys.map(async (key) => client.hGetAll(key))
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

	const [_, restaurant] = await Promise.all([
		client.hIncrBy(restaurantKey, "viewCount", 1),
		client.hGetAll(restaurantKey),
	]);

	return successResponse(res, restaurant);
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

	const reviewData = {
		id: reviewId,
		...data,
		timestamp: Date.now(),
		restaurantId,
	};

	await Promise.all([
		client.lPush(reviewKey, reviewId),
		client.hSet(reviewDetailsKey, reviewData),
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
