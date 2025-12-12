import type { Request, Response } from "express";
import type { Restaurant } from "../schemas/restaurants.js";
import { initializeRedis } from "../client.js";

export const createRestaurant = async (req: Request, res: Response) => {
	const data = req.body as Restaurant;
	const client = await initializeRedis();

	res.json(data);
};
