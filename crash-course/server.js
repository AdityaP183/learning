import { WebSocketServer } from "ws";

const wss = new WebSocketServer({ port: 8080 });

// 0: CONNECTING
// 1: OPEN (the only state where .send() can be used safely)
// 2: CLOSING
// 3: CLOSED

// Connection
wss.on("connection", (socket, request) => {
	const ip = request.socket.remoteAddress;

	socket.on("message", (rawData) => {
		console.log({ rawData });

		const message = rawData.toString();

		wss.clients.forEach((client) => {
			if (client.readyState === WebSocket.OPEN)
				client.send(`Server broadcast: ${message}`);
		});
	});

	socket.on("error", (err) => {
		console.log(`Error: ${err.message}: ${ip}`);
	});

	socket.on("close", () => {
		console.log("Client disconnected");
	});
});

console.log("WebSocket Server is live on ws://localhost:8080");
