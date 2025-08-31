import { AuthTokens } from "@shared/types";
import { createServiceError } from "@shared/utils";
import bcrypt from "bcryptjs";
import prisma from "./db";
import jwt, { SignOptions } from "jsonwebtoken";
import { StringValue } from "ms";

export class AuthService {
	private readonly jwtSecret: string;
	private readonly jwtRefreshSecret: string;
	private readonly jwtExpiresIn: string;
	private readonly jwtRefreshExpiresIn: string;
	private readonly bcryptRounds: number;

	constructor() {
		this.jwtSecret = process.env.JWT_SECRET!;
		this.jwtRefreshSecret = process.env.JWT_REFRESH_SECRET!;
		this.jwtExpiresIn = process.env.JWT_EXPIRES_IN || "15m";
		this.jwtRefreshExpiresIn = process.env.JWT_REFRESH_EXPIRES_IN || "7d";
		this.bcryptRounds = parseInt(process.env.BCRYPT_ROUNDS || "10", 10);

		if (!this.jwtSecret || !this.jwtRefreshSecret) {
			throw new Error(
				"Missing JWT secret. Define JWT_SECRET and JWT_REFRESH_SECRET environment variables."
			);
		}
	}

	private async generateAuthTokens(
		userId: string,
		email: string
	): Promise<AuthTokens> {
		const payload = { userId, email };

		const accessTokenOptions: SignOptions = {
			expiresIn: this.jwtExpiresIn as StringValue,
		};

		const refreshTokenOptions: SignOptions = {
			expiresIn: this.jwtRefreshExpiresIn as StringValue,
		};

		const accessToken = jwt.sign(
			payload,
			this.jwtSecret,
			accessTokenOptions
		);

		const refreshToken = jwt.sign(
			payload,
			this.jwtRefreshSecret,
			refreshTokenOptions
		);

		const expiresAt = new Date();
		expiresAt.setDate(expiresAt.getDate() + 7);

		await prisma.refreshToken.create({
			data: {
				userId,
				token: refreshToken,
				expiresAt,
			},
		});

		return {
			accessToken,
			refreshToken,
		};
	}

	private async generateTokens(
		userId: string,
		email: string
	): Promise<AuthTokens> {
		const payload = { userId, email };

		// Generate access token
		const accessTokenOptions: SignOptions = {
			expiresIn: this.jwtExpiresIn as StringValue,
		};

		const accessToken = jwt.sign(
			payload,
			this.jwtSecret,
			accessTokenOptions
		) as string;

		// Generate refresh token
		const refreshTokenOptions: SignOptions = {
			expiresIn: this.jwtRefreshExpiresIn as StringValue,
		};
		const refreshToken = jwt.sign(
			payload,
			this.jwtRefreshSecret,
			refreshTokenOptions
		) as string;

		// Store refresh token in the database
		const expiresAt = new Date();
		expiresAt.setDate(expiresAt.getDate() + 7); // 7 days from now

		await prisma.refreshToken.create({
			data: {
				userId,
				token: refreshToken,
				expiresAt,
			},
		});

		return {
			accessToken,
			refreshToken,
		};
	}

	async register(email: string, password: string): Promise<AuthTokens> {
		const existingUser = await prisma.user.findUnique({
			where: {
				email,
			},
		});

		if (existingUser) {
			throw createServiceError("User already exists", 409);
		}

		const hashedPassword = await bcrypt.hash(password, this.bcryptRounds);

		const user = await prisma.user.create({
			data: {
				email,
				password: hashedPassword,
			},
		});

		return this.generateAuthTokens(user.id, user.email);
	}

	async login(email: string, password: string): Promise<AuthTokens> {
		const user = await prisma.user.findUnique({
			where: { email },
		});

		if (!user) {
			throw createServiceError("Invalid email or password", 401);
		}

		const isPasswordValid = await bcrypt.compare(password, user.password);
		if (!isPasswordValid) {
			throw createServiceError("Invalid email or password", 401);
		}

		return this.generateTokens(user.id, user.email);
	}
}
