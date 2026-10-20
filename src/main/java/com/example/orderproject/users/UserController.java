package com.example.orderproject.users;

import com.example.orderproject.exceptions.EmailAlreadyExistsException;
import com.example.orderproject.users.dtos.CreateUserDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes= "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBasicUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        if(service.checkEmailIsUnique(createUserDTO.getEmail())) {
            service.createUser(createUserDTO);
        } else {
            log.warn("Email already exists");
            throw new EmailAlreadyExistsException("Email already exists");
        }
    }
}
