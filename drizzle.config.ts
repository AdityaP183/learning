import "dotenv/config";
import { defineConfig } from "drizzle-kit";

export default defineConfig({
	out: "./src/drizzle/migrations",
	schema: "./src/drizzle/schema.ts",
	dialect: "postgresql",
	dbCredentials: {
		// biome-ignore lint/style/noNonNullAssertion: true
		url: process.env.DATABASE_URL!,
	},
});
