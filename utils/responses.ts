import type { Response } from "express";

export function successResponse(
	res: Response,
	data: any,
	message: string = "Success"
) {
	return res.status(200).json({
		sucess: true,
		message,
		data,
	});
}

export function errorResponse(
	res: Response,
	httpStatus: number,
	error: string
) {
	return res.status(httpStatus).json({
		sucess: false,
		error,
	});
}
