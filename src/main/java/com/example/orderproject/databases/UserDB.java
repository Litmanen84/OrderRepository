package com.example.orderproject.databases;

import com.example.orderproject.users.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    private static List<User> users = new ArrayList<>(List.of(admin));


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
    }
}
