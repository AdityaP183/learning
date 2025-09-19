"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";
import { toast } from "sonner";
import { signUpEmailAction } from "@/actions/sign-up-email.action";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

export default function RegisterForm() {
	const [isPending, setIsPending] = useState(false);
	const router = useRouter();

	async function handleSubmit(evt: React.FormEvent<HTMLFormElement>) {
		evt.preventDefault();

		setIsPending(true);

		const formData = new FormData(evt.currentTarget);

		const { error } = await signUpEmailAction(formData);

		if (error) {
			toast.error(error);
		} else {
			toast.success("Account created successfully");
			router.push("/auth/login");
		}

		setIsPending(false);
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

			<Button type="submit" className="w-full" disabled={isPending}>
				Register
			</Button>
		</form>
	);
}
