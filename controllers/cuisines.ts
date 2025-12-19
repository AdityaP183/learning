import type { Request, Response } from "express";
import { initializeRedis } from "../client.js";
import { cuisineKey, cuisinesKey, restaurantKeyById } from "../utils/keys.js";
import { successResponse } from "../utils/responses.js";

export const getAllCuisines = async (req: Request, res: Response) => {
	const client = await initializeRedis();

	const cuisines = await client.sMembers("redis:cuisines");

	return successResponse(res, cuisines);
};

export const getACuisines = async (
	req: Request<{ cuisine: string }>,
	res: Response
) => {
	const { cuisine } = req.params;

	const client = await initializeRedis();

	const restaurantIds = await client.sMembers(cuisineKey(cuisine));

	const restaurants = await Promise.all(
		restaurantIds.map((id) => client.hGet(restaurantKeyById(id), "name"))
	);

	return successResponse(res, restaurants);
};
