import { Router } from "express";
import {
	createRestaurant,
	createRestaurantReview,
	deleteRestaurantReview,
	getRestaurantById,
	getRestaurantReviews,
	getRestaurants,
} from "../controllers/restaurants.js";
import { checkRestaurantExists } from "../middlewares/checkRestaurantId.js";
import { validate } from "../middlewares/validate.js";
import { RestaurantSchema } from "../schemas/restaurants.js";
import { ReviewSchema } from "../schemas/reviews.js";

const router = Router();

router.post("/", validate(RestaurantSchema), createRestaurant);
router.get("/", getRestaurants);
router.post(
	"/:restaurantId/reviews",
	checkRestaurantExists,
	validate(ReviewSchema),
	createRestaurantReview
);
router.get(
	"/:restaurantId/reviews",
	checkRestaurantExists,
	getRestaurantReviews
);
router.delete(
	"/:restaurantId/reviews/:reviewId",
	checkRestaurantExists,
	deleteRestaurantReview
);
router.get("/:restaurantId", checkRestaurantExists, getRestaurantById);

export default router;
