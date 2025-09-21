import { betterAuth } from "better-auth";
import { prismaAdapter } from "better-auth/adapters/prisma";
import { APIError, createAuthMiddleware } from "better-auth/api";
import { nextCookies } from "better-auth/next-js";
import { prisma } from "./prisma";
import { getValidDomains, normalizeName } from "./utils";

export const auth = betterAuth({
	database: prismaAdapter(prisma, {
		provider: "postgresql",
	}),
	emailAndPassword: {
		enabled: true,
		minPasswordLength: 6,
		autoSignIn: false,
	},
	advanced: {
		database: {
			generateId: false,
		},
	},
	hooks: {
		before: createAuthMiddleware(async (ctx) => {
			if (ctx.path === "/sign-up/email") {
				const email = String(ctx.body.email);
				const domain = email.split("@")[1];

				const VALID_DOMAINS = getValidDomains();
				if (!VALID_DOMAINS.includes(domain)) {
					throw new APIError("BAD_REQUEST", {
						message:
							"Invalid email domain. Please use a valid domain.",
					});
				}

				const name = normalizeName(ctx.body.name);

				return {
					context: {
						...ctx,
						body: {
							...ctx.body,
							name,
						},
					},
				};
			}
		}),
	},
	plugins: [nextCookies()],
});

export type ErrorCode = keyof typeof auth.$ERROR_CODES | "UNKOWN";
