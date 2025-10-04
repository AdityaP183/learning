import Fastify from "fastify";

const fastify = new Fastify({
	logger: true,
});

fastify.get("/", function (request, reply) {
	reply.send({ status: "ok", message: "Server is running" });
});

const start = async () => {
	try {
		await fastify.listen({ port: 8000 });
        console.log("Server listening on port 8000");
	} catch (err) {
		fastify.log.error(err);
		process.exit(1);
	}
};

start();
