import { headers } from "next/headers";
import { redirect } from "next/navigation";
import ReturnButton from "@/components/buttons/return-btn";
import SignOutButton from "@/components/buttons/sign-out-btn";
import { auth } from "@/lib/auth";

export default async function Page() {
	const session = await auth.api.getSession({
		headers: await headers(),
	});

	if (!session) {
		redirect("/auth/login");
	}

	return (
		<div className="px-8 py-16 container mx-auto max-w-screen-lg space-y-8">
			<div className="space-y-4">
				<ReturnButton href="/" label="Home" />
				<h1 className="text-3xl font-bold">Profile</h1>
			</div>

			<hr className="max-w-sm" />

			<SignOutButton />

			<pre className="text-sm overflow-clip">
				{JSON.stringify(session, null, 2)}
			</pre>
		</div>
	);
}
