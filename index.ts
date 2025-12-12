import express from "express";

import restuantsRouter from "./routes/restaurants.js";
import cuisinesRouter from "./routes/cuisines.js";
import { errorHandler } from "./middlewares/errorHandler.js";

const PORT = process.env.PORT || 3000;

const app = express();

// Middlewares
app.use(express.json());

// Routes
app.get("/", (req, res) => {
	res.json({
		status: "ok",
		message: "Server is running",
	});
});
app.use("/cuisines", cuisinesRouter);
app.use("/restaurants", restuantsRouter);

app.use(errorHandler);

app.listen(PORT, () => {
	console.log(`Server running on port ${PORT}`);
}).on("error", (err) => {
	throw new Error(err.message);
});
