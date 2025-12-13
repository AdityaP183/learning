export function getKeyName(...args: string[]) {
	return `redis:${args.join(":")}`;
}

export const restaurantKeyById = (id: string) => getKeyName("restaurants", id);

export const cuisineKeyById = (id: string) => getKeyName("cuisines", id);
