package com.example.orderproject.db;

import com.example.orderproject.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDB {
    private static List<User> users = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(UserDB.class);

    public void save(User user) {
        users.add(user);
        logger.info("User saved: {}", user);
    }
}
