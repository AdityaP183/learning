import { betterAuth } from "better-auth";
import { drizzleAdapter } from "better-auth/adapters/drizzle";
import { nextCookies } from "better-auth/next-js";
import { db } from "@/drizzle/db";
import * as schema from "@/drizzle/schema";

export const auth = betterAuth({
	database: drizzleAdapter(db, {
		schema,
		provider: "pg",
	}),
	session: {
		cookieCache: {
			enabled: true,
			maxAge: 60 * 5,
		},
	},
	plugins: [nextCookies()],
	emailAndPassword: {
		enabled: true,
	},
});
