"use server";

import { APIError } from "better-auth";
import { headers } from "next/headers";
import { redirect } from "next/navigation";
import { auth, type ErrorCode } from "@/lib/auth";

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
		if (err instanceof APIError) {
			const errCode = err.body ? (err.body.code as ErrorCode) : "UNKNOWN";
			console.dir(err, { depth: 5 });
			switch (errCode) {
				case "EMAIL_NOT_VERIFIED":
					redirect("/auth/verify?error=email_not_verified");
					break;
				default:
					return { error: err.message };
			}
		}

		return { error: "Internal Server Error" };
	}
}
