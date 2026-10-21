package com.example.orderproject.users;

import com.example.orderproject.exceptions.UserAlreadyExistsException;
import com.example.orderproject.exceptions.UserNotFoundException;
import com.example.orderproject.security.SecurityService;
import com.example.orderproject.users.dtos.CreateUserDTO;
import com.example.orderproject.users.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.dtos.UserGenericDetailsDTO;
import com.example.orderproject.users.enums.Role;
import com.example.orderproject.users.mappers.UserMapper;
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

    public void createUser(CreateUserDTO createUserDTO){
        repo.createUser(userMapper.fromCreateUserDtoToUser(createUserDTO));
    }

    public boolean checkEmailIsUnique(String email){
        return repo.checkEmailIsUnique(email);
    }

    public List<UserGenericDetailsDTO> getAllUsers() {
        return repo.getAllUsers().stream()
                .map(userMapper::fromUserToGenericDetails)
                .toList();
    }

    public UserFullDetailsDTO getUserDetails(UUID id) {
        return repo.getUserDetails(id)
                .map(userMapper::fromUserToUserFullDetails)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
