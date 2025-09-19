"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";
import { toast } from "sonner";
import { Button } from "@/components/ui/button";
import { signOut } from "@/lib/auth-client";

export default function SignOutButton() {
	const [isPending, setIsPending] = useState(false);
	const router = useRouter();

	async function handleClick() {
		await signOut({
			fetchOptions: {
				onRequest: () => {
					setIsPending(true);
				},
				onResponse: () => {
					setIsPending(false);
				},
				onError: (ctx) => {
					toast.error(ctx.error.message);
				},
				onSuccess: () => {
					router.push("/auth/login");
					toast.success("Logged out successfully");
				},
			},
		});
	}

	return (
		<Button
			onClick={handleClick}
			size="sm"
			variant="destructive"
			disabled={isPending}
		>
			Sign out
		</Button>
	);
}
