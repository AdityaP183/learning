import "dotenv/config";
import { drizzle } from "drizzle-orm/node-postgres";

export const db = drizzle({
	connection: {
		// biome-ignore lint/style/noNonNullAssertion: true
		connectionString: process.env.DATABASE_URL!,
	},
});
