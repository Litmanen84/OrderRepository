package com.example.orderproject.security;

import com.example.orderproject.exceptions.UnauthorizedException;
import com.example.orderproject.users.User;
import com.example.orderproject.users.UserRepository;
import com.example.orderproject.users.UserService;
import com.example.orderproject.users.enums.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class SecurityService {
    private static final Logger log = LoggerFactory.getLogger(SecurityService.class);
    private final UserRepository userRepo;
    private final UserService userService;

    public SecurityService(UserRepository userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    public User validateAuthorization(String auth, Feature feature){
        if(auth == null || auth.isBlank() || !auth.startsWith("Basic ")){
            throw new UnauthorizedException();
        }

        String strippedCredentials = auth.substring("Basic ".length());
        String decodedCredentials;
        try {
            decodedCredentials = new String(
                    Base64.getDecoder().decode(strippedCredentials),
                    StandardCharsets.UTF_8
            );
        } catch (IllegalArgumentException e) {
            throw new UnauthorizedException();
        }
        String[] credentials = decodedCredentials.split(":", 2);
        if (credentials.length != 2) {
            throw new UnauthorizedException();
        }
        String email = credentials[0];
        String password = credentials[1];

        User user = userRepo.getUserByEmail(email)
                .orElseThrow(UnauthorizedException::new);

        if (!user.doesPasswordMatch(password)) {
            throw new UnauthorizedException();
        }

        if (!user.canHaveAccessTo(feature)) {
            throw new UnauthorizedException();
        }
        return user;
    }
}
