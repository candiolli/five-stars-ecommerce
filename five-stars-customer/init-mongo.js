db.createUser(
    {
        user: "candiolli",
        pwd: "candiolli123",
        roles: [
            {
                role: "readWrite",
                db: "five-stars-customer"
            }
        ]
    }
)