import { Router } from "express";
import {
	createRestaurant,
	getRestaurantById,
	getRestaurants,
} from "../controllers/restaurants.js";
import { validate } from "../middlewares/validate.js";
import { RestaurantSchema } from "../schemas/restaurants.js";
import { checkRestaurantExists } from "../middlewares/checkRestaurantId.js";

const router = Router();

router.post("/", validate(RestaurantSchema), createRestaurant);
router.get("/", getRestaurants);
router.get("/:restaurantId", checkRestaurantExists, getRestaurantById);

export default router;
