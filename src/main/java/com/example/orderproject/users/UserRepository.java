package com.example.orderproject.users;

import com.example.orderproject.db.UserDB;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final UserDB db;

    public UserRepository(UserDB db) {
        this.db = db;
    }

    public void createUser(User user) {
        db.save(user);
    }

}
