package com.example.orderproject.users.mappers;

import com.example.orderproject.users.User;
import com.example.orderproject.users.dtos.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromCreateUserDtoToUser(CreateUserDTO createUserDTO) {
        return new User(
                createUserDTO.getFirstname(),
                createUserDTO.getLastname(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword(),
                createUserDTO.getAddress(),
                createUserDTO.getPhoneNumber()
        );
    }
}
