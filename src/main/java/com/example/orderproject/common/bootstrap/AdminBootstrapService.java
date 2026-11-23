package com.example.orderproject.common.bootstrap;

import com.example.orderproject.users.domain.User;
import com.example.orderproject.users.domain.persondetails.Address;
import com.example.orderproject.users.domain.persondetails.enums.Role;
import com.example.orderproject.users.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminBootstrapService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminBootstrapService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createAdminIfNotExists(String email, String password) {

        if (userRepository.existsByRole(Role.ADMIN)) {
            return;
        }

        User admin = new User(
                "System",
                "Administrator",
                email,
                passwordEncoder.encode(password),
                new Address(
                        "Via vai",
                        "23",
                        "Caserta",
                        "81100"
                ),
                "123456789",
                Role.ADMIN
        );

        userRepository.save(admin);
    }
}
