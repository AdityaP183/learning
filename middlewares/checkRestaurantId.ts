import type { Request, Response, NextFunction } from "express";
import { restaurantKeyById } from "../utils/keys.js";
import { errorResponse } from "../utils/responses.js";
import { initializeRedis } from "../client.js";

export const checkRestaurantExists = async (
	req: Request<{ restaurantId: string }>,
	res: Response,
	next: NextFunction
) => {
	const { restaurantId } = req.params;
	if (!restaurantId) {
		return errorResponse(res, 400, "Missing restaurant id");
	}

	const client = await initializeRedis();
	const key = restaurantKeyById(restaurantId);

	const exists = await client.exists(key);
	if (!exists) {
		return errorResponse(
			res,
			404,
			`Restaurant with id ${restaurantId} not found`
		);
	}

	next();
};
