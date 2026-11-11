package com.example.orderproject.users.service;

import com.example.orderproject.users.exceptions.UserNotFoundException;
import com.example.orderproject.users.repositories.UserRepository;
import com.example.orderproject.users.api.dtos.CreateUserDTO;
import com.example.orderproject.users.api.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.api.dtos.UserGenericDetailsDTO;
import com.example.orderproject.users.service.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository repo;

    public UserService(UserRepository repo, UserMapper userMapper) {
        this.repo = repo;
        this.userMapper = userMapper;
    }

//    public void createUser(CreateUserDTO createUserDTO){
//        repo.createUser(userMapper.fromCreateUserDtoToUser(createUserDTO));
//    }
//
//    public boolean checkEmailIsUnique(String email){
//        return repo.checkEmailIsUnique(email);
//    }
//
//    public List<UserGenericDetailsDTO> getAllUsers() {
//        return repo.getAllUsers().stream()
//                .map(userMapper::fromUserToGenericDetails)
//                .toList();
//    }
//
//    public UserFullDetailsDTO getUserDetails(UUID id) {
//        return repo.getUserDetails(id)
//                .map(userMapper::fromUserToUserFullDetails)
//                .orElseThrow(() -> new UserNotFoundException("User not found"));
//    }
}
