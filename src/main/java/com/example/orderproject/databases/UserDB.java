package com.example.orderproject.databases;

import com.example.orderproject.users.*;
import com.example.orderproject.users.enums.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDB {
    private Logger logger = LoggerFactory.getLogger(UserDB.class);

    static Admin admin = new Admin("Ciccio", "Magnotta", "ciccio.magnotta@gmail.com", "ciao123",
            new Address(
                    "Via Vai",
                    23,
                    "Caserta",
                    "Italy",
                    "81100"
            ),
            new PhoneNumber(
                    "39",
                    "347272924"
            ));

    static BasicUser basicUser = new BasicUser(
            "Cosimo", "Andrea", "cosimo.andrea@gmail.com", "ciao123",
            new Address(
                    "Via Villa",
                    23,
                    "Caserta",
                    "Italy",
                    "81100"
            ),
            new PhoneNumber(
                    "39",
                    "347472924"
            ));


    private static List<User> users = new ArrayList<>(List.of(admin, basicUser));


    public void save(BasicUser basicUser) {
        users.add(basicUser);
        logger.info("User saved: {}", basicUser);
    }

    public Optional<User> getUserByEmail(String email){
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public boolean checkEmailIsUnique(String email) {
        return users.stream().noneMatch(user -> user.getEmail().equals(email));
    }

    public List<User> getAllUsers() {
        return users.stream()
                .filter(u -> u.getRole().equals(Role.USER))
                .toList();
    }

    public Optional<User> getUserById(UUID id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    //ONLY FOR TESTING PURPOSES
    public Admin getAdmin(){
        return admin;
    }
    //ONLY FOR TESTING PURPOSES
    public BasicUser getBasicUser(){
        return basicUser;
    }

    //ONLY FOR TESTING PURPOSES
    public void reset() {
        users.clear();
        users.add(admin);
        users.add(basicUser);
    }
}
