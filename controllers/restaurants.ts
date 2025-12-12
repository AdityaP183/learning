import type { Request, Response } from "express";
import type { Restaurant } from "../schemas/restaurants.js";

export const createRestaurant = async (req: Request, res: Response) => {
    const data = req.body as Restaurant;
    res.json(data);
};
