package com.example.orderproject.users;

import com.example.orderproject.users.enums.Role;

public class User extends GeneralUser{

    public User(String firstname, String lastname, String email, String password, Address address, PhoneNumber phoneNumber) {
        super(Role.USER, firstname, lastname, email, password, address, phoneNumber);
    }

}
