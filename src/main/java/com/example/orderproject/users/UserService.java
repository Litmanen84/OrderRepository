package com.example.orderproject.users;

import com.example.orderproject.users.dtos.CreateUserDTO;
import com.example.orderproject.users.mappers.UserMapper;
import org.springframework.stereotype.Service;

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
}
