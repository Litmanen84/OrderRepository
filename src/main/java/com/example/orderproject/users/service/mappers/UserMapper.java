package com.example.orderproject.users.service.mappers;

import com.example.orderproject.users.api.dtos.CreateUserDTO;
import com.example.orderproject.users.api.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.api.dtos.UserGenericDetailsDTO;
import com.example.orderproject.users.domain.User;
import com.example.orderproject.users.domain.persondetails.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User fromCreateUserDtoToUser(CreateUserDTO createUserDTO) {
        return new User(
                createUserDTO.getFirstname(),
                createUserDTO.getLastname(),
                createUserDTO.getEmail(),
                hashedPassword(createUserDTO.getPassword()),
                createUserDTO.getAddress(),
                createUserDTO.getPhoneNumber(),
                Role.USER
        );
    }

    public UserGenericDetailsDTO fromUserToGenericDetails(User user){
        return new UserGenericDetailsDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail());
    }

    public UserFullDetailsDTO fromUserToUserFullDetails(User user){
        return new UserFullDetailsDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getRole()
        );
    }

    private String hashedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
