import { ArrowLeft } from "lucide-react";
import Link from "next/link";
import { Button } from "@/components/ui/button";

interface ReturnButtonProps {
	href: string;
	label: string;
}

export default function ReturnButton({ href, label }: ReturnButtonProps) {
	return (
		<Button>
			<Link href={href} className="flex items-center gap-2">
				<ArrowLeft />
				{label}
			</Link>
		</Button>
	);
}
