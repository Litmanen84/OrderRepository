package com.example.orderproject.users;

import com.example.orderproject.users.dtos.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private userService service;

    public UserController(userService service) {
        this.service = service;
    }

    @PostMapping(consumes= "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        service.createUser(createUserDTO);
    }
}
