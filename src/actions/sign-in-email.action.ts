"use server";

import { headers } from "next/headers";
import { auth } from "@/lib/auth";

export async function signInEmailAction(formData: FormData) {
	const email = String(formData.get("email"));
	if (!email) return { error: "Email is required" };

	const password = String(formData.get("password"));
	if (!password) return { error: "Password is required" };

	try {
		await auth.api.signInEmail({
			headers: await headers(),
			body: { email, password },
		});

		//------ Manually Setting Cookies -----
		// const setCookieHeader = res.headers.get("set-cookie");
		// if (setCookieHeader) {
		// 	const cookie = parseSetCookieHeader(setCookieHeader);
		// 	const cookieStore = await cookies();

		// 	const [key, cookieAttributes] = [...cookie.entries()][0];
		// 	const value = cookieAttributes.value;
		// 	const maxAge = cookieAttributes["max-age"];
		// 	const path = cookieAttributes.path;
		// 	const httpOnly = cookieAttributes.httpOnly;
		// 	const sameSite = cookieAttributes.samesite;

		// 	cookieStore.set(key, decodeURIComponent(value), {
		// 		maxAge,
		// 		path,
		// 		httpOnly,
		// 		sameSite,
		// 	});
		// }

		return { error: null };
	} catch (err) {
		if (err instanceof Error) {
			return { error: "Oops! Something went wrong" };
		}

		return { error: "Something went wrong" };
	}
}
