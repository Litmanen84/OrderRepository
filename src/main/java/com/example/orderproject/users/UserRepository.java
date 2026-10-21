package com.example.orderproject.users;

import com.example.orderproject.databases.UserDB;
import com.example.orderproject.users.dtos.UserGenericDetailsDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<User> getAllUsers() {
        return userDB.getAllUsers();
    }

    public Optional<User> getUserDetails(UUID id){
        return userDB.getUserById(id);
    }
}
