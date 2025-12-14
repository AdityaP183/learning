import { zodResolver } from "@hookform/resolvers/zod";
import { useRouter } from "next/navigation";
import { useForm } from "react-hook-form";
import { toast } from "sonner";
import { z } from "zod";
import { authClient } from "@/lib/auth-client";
import { Button } from "../ui/button";
import {
	Form,
	FormControl,
	FormField,
	FormItem,
	FormLabel,
	FormMessage,
} from "../ui/form";
import { Input } from "../ui/input";
import { LoadingSwap } from "../ui/loading-swap";
import { PasswordInput } from "../ui/password-input";

const signInSchema = z.object({
	email: z.email().min(1),
	password: z.string().min(6),
});

type SignInForm = z.infer<typeof signInSchema>;

export default function SignIn() {
	const router = useRouter();
	const form = useForm<SignInForm>({
		resolver: zodResolver(signInSchema),
		defaultValues: {
			email: "",
			password: "",
		},
	});

	const { isSubmitting } = form.formState;

	async function handleSignIn(data: SignInForm) {
		await authClient.signIn.email(
			{
				...data,
				callbackURL: "/",
			},
			{
				onError: (error) => {
					toast.error(error.error.message || "Failed to sign in!");
				},
				onSuccess: () => {
					toast.success("Logged In successfully!");
					router.push("/");
				},
			}
		);
	}

	return (
		<Form {...form}>
			<form
				className="space-y-4"
				onSubmit={form.handleSubmit(handleSignIn)}
			>
				<FormField
					control={form.control}
					name="email"
					render={({ field }) => (
						<FormItem>
							<FormLabel>Email</FormLabel>
							<FormControl>
								<Input type="email" {...field} />
							</FormControl>
							<FormMessage />
						</FormItem>
					)}
				/>

				<FormField
					control={form.control}
					name="password"
					render={({ field }) => (
						<FormItem>
							<FormLabel>Password</FormLabel>
							<FormControl>
								<PasswordInput {...field} />
							</FormControl>
							<FormMessage />
						</FormItem>
					)}
				/>

				<Button
					type="submit"
					disabled={isSubmitting}
					className="w-full"
				>
					<LoadingSwap isLoading={isSubmitting}>Sign In</LoadingSwap>
				</Button>
			</form>
		</Form>
	);
}
