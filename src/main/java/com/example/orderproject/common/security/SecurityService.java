package com.example.orderproject.common.security;

import com.example.orderproject.users.exceptions.UnauthorizedException;
import com.example.orderproject.users.domain.User;
import com.example.orderproject.users.repositories.UserRepository;
import com.example.orderproject.users.domain.persondetails.enums.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class SecurityService {
    private static final Logger log = LoggerFactory.getLogger(SecurityService.class);
    private final UserRepository userRepo;
    private PasswordEncoder encoder;

    public SecurityService(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
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

        User user = userRepo.findByEmail(email)
                .orElseThrow(UnauthorizedException::new);

        if (!encoder.matches(password, user.getHashedPassword())) {
            throw new UnauthorizedException();
        }

        if (!user.canHaveAccessTo(feature)) {
            throw new UnauthorizedException();
        }
        return user;
    }
}
