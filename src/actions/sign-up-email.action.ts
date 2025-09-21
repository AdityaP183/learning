"use server";

import { APIError } from "better-auth/api";
import { auth, type ErrorCode } from "@/lib/auth";

export async function signUpEmailAction(formData: FormData) {
	const name = String(formData.get("name"));
	if (!name) return { error: "Name is required" };

	const email = String(formData.get("email"));
	if (!email) return { error: "Email is required" };

	const password = String(formData.get("password"));
	if (!password) return { error: "Password is required" };

	try {
		await auth.api.signUpEmail({ body: { name, email, password } });
		return { error: null };
	} catch (err) {
		if (err instanceof APIError) {
			const errCode = err.body ? (err.body.code as ErrorCode) : "UNKOWN";

			switch (errCode) {
				default:
					return {
						error: err.message,
					};
			}
		}

		return { error: "Something went wrong" };
	}
}
