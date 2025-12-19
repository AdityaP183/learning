import { Router } from "express";
import { getACuisines, getAllCuisines } from "../controllers/cuisines.js";

const router = Router();

router.get("/", getAllCuisines);
router.get("/:cuisine", getACuisines);

export default router;
