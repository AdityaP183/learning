import { Router } from "express";
import * as authController from "./auth-controller";
import { validateRequest } from "@shared/middleware";
import { loginSchema, registerSchema } from "./validation";
import type { Router as ExpressRouter } from "express";

const router: ExpressRouter = Router();

// Public Routes
router.post(
	"/register",
	validateRequest(registerSchema),
	authController.register
);
router.post("/login", validateRequest(loginSchema), authController.login);

export default router;
