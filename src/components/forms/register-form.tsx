"use client";

import { useState } from "react";
import { Label } from "@/components/ui/label";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { toast } from "sonner";
import { signUp } from "@/lib/auth-client";

export default function RegisterForm() {
	const [] = useState();

	async function handleSubmit(evt: React.FormEvent<HTMLFormElement>) {
		evt.preventDefault();

		const formData = new FormData(evt.currentTarget);

		const name = String(formData.get("name"));
		if (!name) return toast.error("Name is required");

		const email = String(formData.get("email"));
		if (!email) return toast.error("Email is required");

		const password = String(formData.get("password"));
		if (!password) return toast.error("Password is required");

		await signUp.email(
			{ name, email, password },
			{
				onRequest: () => {},
				onResponse: () => {},
				onError: (ctx) => {
					toast.error(ctx.error.message);
				},
				onSuccess: () => {},
			}
		);
	}

	return (
		<form onSubmit={handleSubmit} className="max-w-sm w-full space-y-4">
			<div className="space-y-2">
				<Label htmlFor="name">Name</Label>
				<Input
					id="name"
					name="name"
					required
					className="w-full px-3 py-2 border rounded"
				/>
			</div>
			<div className="space-y-2">
				<Label htmlFor="email">Email</Label>
				<Input
					id="email"
					name="email"
					type="email"
					required
					className="w-full px-3 py-2 border rounded"
				/>
			</div>
			<div className="space-y-2">
				<Label htmlFor="password">Password</Label>
				<Input
					id="password"
					name="password"
					type="password"
					required
					className="w-full px-3 py-2 border rounded"
				/>
			</div>

			<Button type="submit" className="w-full">
				Register
			</Button>
		</form>
	);
}
