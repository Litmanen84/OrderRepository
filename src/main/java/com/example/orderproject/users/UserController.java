package com.example.orderproject.users;

import com.example.orderproject.exceptions.EmailAlreadyExistsException;
import com.example.orderproject.security.SecurityService;
import com.example.orderproject.users.dtos.CreateUserDTO;
import com.example.orderproject.users.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.dtos.UserGenericDetailsDTO;
import com.example.orderproject.users.enums.Feature;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService service;
    private final SecurityService security;

    public UserController(UserService service, SecurityService security) {
        this.service = service;
        this.security = security;
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

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserGenericDetailsDTO> getAllUsers(@RequestHeader(value = "Authorization", required = false) String auth){
        security.validateAuthorization(auth, Feature.SEE_ALL_USERS);
        return service.getAllUsers();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserFullDetailsDTO getUserDetails(@RequestHeader(value = "Authorization", required = false) String auth, @PathVariable("id") UUID id){
        security.validateAuthorization(auth, Feature.SEE_USER_DETAILS);
        return service.getUserDetails(id);
    }
}
