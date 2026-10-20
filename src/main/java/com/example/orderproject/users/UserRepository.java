package com.example.orderproject.users;

import com.example.orderproject.databases.UserDB;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    private final UserDB userDB;

    public UserRepository(UserDB userDB) {
        this.userDB = userDB;
    }

    public void createUser(BasicUser basicUser) {
        userDB.save(basicUser);
    }

    public Optional<User> getUserByEmail(String email){
        return userDB.getUserByEmail(email);
    }

    public boolean checkEmailIsUnique(String email) {
        return userDB.checkEmailIsUnique(email);
    }
}
