import type { Request, Response, NextFunction } from "express";

export function asyncHandler(
	fn: (req: Request, res: Response, next: NextFunction) => Promise<void>
) {
	return (req: Request, res: Response, next: NextFunction): void => {
		Promise.resolve(fn(req, res, next)).catch(next);
	};
}

export function validateRequest(schema: any) {
	return (req: Request, res: Response, next: NextFunction): void => {
		const { error } = schema.validate(req.body);

		if (error) {
			const errors: Record<string, string[]> = {};
			error.details.forEach((detail: any) => {
				if (errors[detail.context.key]) {
					errors[detail.context.key].push(detail.message);
				} else {
					errors[detail.context.key] = [detail.message];
				}
			});
			res.status(400).json({
				success: false,
				message: "Validation error",
				errors,
			});
		}

		next();
	};
}
