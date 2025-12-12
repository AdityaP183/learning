import { Router } from "express";
import { createRestaurant } from "../controllers/restaurants.js";
import { validate } from "../middlewares/validate.js";
import { RestaurantSchema } from "../schemas/restaurants.js";

const router = Router();

router.post("/", validate(RestaurantSchema), createRestaurant);

export default router;
