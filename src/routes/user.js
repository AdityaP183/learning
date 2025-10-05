async function userRouter(fastify, opts) {
    fastify.post("/api/users", async (request, reply) => {
        return {
            status: "ok",
            message: "User created successfully"
        }
    })
}

export default userRouter
