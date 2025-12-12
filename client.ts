import { createClient, type RedisClientType } from "redis";

let client: RedisClientType | null = null;

export async function initializeRedis() {
	if (!client) {
		client = createClient({ url: "redis://localhost:7000" });
		client.on("error", (err) => console.log("Redis Client Error", err));
		client.on("connect", () => console.log("Redis Client Connected"));
		await client.connect();
	}
	return client;
}
