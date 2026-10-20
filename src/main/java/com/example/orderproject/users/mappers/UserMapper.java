package com.example.orderproject.users.mappers;

import com.example.orderproject.users.BasicUser;
import com.example.orderproject.users.dtos.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public BasicUser fromCreateUserDtoToUser(CreateUserDTO createUserDTO) {
        return new BasicUser(
                createUserDTO.getFirstname(),
                createUserDTO.getLastname(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword(),
                createUserDTO.getAddress(),
                createUserDTO.getPhoneNumber()
        );
    }
}
