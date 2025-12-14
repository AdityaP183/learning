"use client";

import SignIn from "@/components/auth/sign-in";
import SignUp from "@/components/auth/sign-up";
import {
    Card,
    CardContent,
    CardFooter,
    CardHeader,
    CardTitle,
} from "@/components/ui/card";
import { Separator } from "@/components/ui/separator";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { useRouter } from "next/navigation";
import { useState } from "react";

type Tab = "signin" | "signup" | "email-verification" | "forgot-password";

export default function LoginPage() {
	const router = useRouter();
	const [email, setEmail] = useState("");
	const [selectedTab, setSelectedTab] = useState<Tab>("signin");

	return (
		<Tabs
			value={selectedTab}
			onValueChange={(t) => setSelectedTab(t as Tab)}
			className="max-auto w-full my-6 px-4"
		>
			{(selectedTab === "signin" || selectedTab === "signup") && (
				<TabsList>
					<TabsTrigger value="signin">Sign In</TabsTrigger>
					<TabsTrigger value="signup">Sign Up</TabsTrigger>
				</TabsList>
			)}
			<TabsContent value="signin">
				<Card>
					<CardHeader className="text-2xl font-bold">
						<CardTitle>Sign In</CardTitle>
					</CardHeader>
					<CardContent>
						<SignIn
							// openEmailVerificationTab={openEmailVerificationTab}
							// openForgotPassword={() =>
							// 	setSelectedTab("forgot-password")
							// }
						/>
					</CardContent>

					<Separator />

					<CardFooter className="grid grid-cols-2 gap-3">
						{/* <SocialAuthButtons /> */}
					</CardFooter>
				</Card>
			</TabsContent>

			<TabsContent value="signup">
				<Card>
					<CardHeader className="text-2xl font-bold">
						<CardTitle>Sign Up</CardTitle>
					</CardHeader>
					<CardContent>
						<SignUp
							// openEmailVerificationTab={openEmailVerificationTab}
						/>
					</CardContent>

					<Separator />

					<CardFooter className="grid grid-cols-2 gap-3">
						{/* <SocialAuthButtons /> */}
					</CardFooter>
				</Card>
			</TabsContent>

			<TabsContent value="email-verification">
				<Card>
					<CardHeader className="text-2xl font-bold">
						<CardTitle>Verify Your Email</CardTitle>
					</CardHeader>
					<CardContent>
						{/* <EmailVerification email={email} /> */}
					</CardContent>
				</Card>
			</TabsContent>

			<TabsContent value="forgot-password">
				<Card>
					<CardHeader className="text-2xl font-bold">
						<CardTitle>Forgot Password</CardTitle>
					</CardHeader>
					<CardContent>
						{/* <ForgotPassword
							openSignInTab={() => setSelectedTab("signin")}
						/> */}
					</CardContent>
				</Card>
			</TabsContent>
		</Tabs>
	);
}
