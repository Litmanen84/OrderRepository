package com.example.orderproject.users.mappers;

import com.example.orderproject.users.BasicUser;
import com.example.orderproject.users.User;
import com.example.orderproject.users.dtos.CreateUserDTO;
import com.example.orderproject.users.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.dtos.UserGenericDetailsDTO;
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
}
