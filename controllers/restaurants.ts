import type { Request, Response } from "express";
import type { Restaurant } from "../schemas/restaurants.js";
import { initializeRedis } from "../client.js";
import { nanoid } from "nanoid";
import { restaurantKeyById } from "../utils/keys.js";
import { successResponse } from "../utils/responses.js";

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

export const getRestaurants = async (req: Request, res: Response) => {};

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
