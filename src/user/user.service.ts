import { ConflictException, Injectable } from "@nestjs/common";
import { InjectModel } from "@nestjs/mongoose";
import { Model } from "mongoose";
import { RegisterDto } from "src/auth/dto/registerUser.dto";
import { User } from "./schemas/user.schema";

@Injectable()
export class UserService {
	constructor(@InjectModel(User.name) private userModel: Model<User>) {}

	async createUser(registerUserDto: RegisterDto) {
		try {
			return await this.userModel.create({
				firstName: registerUserDto.firstName,
				lastName: registerUserDto.lastName,
				email: registerUserDto.email,
				password: registerUserDto.password,
			});
		} catch (err) {
			if (err.code === 11000) {
				throw new ConflictException("User with this email already exists");
			}

			throw err;
		}
	}
}
