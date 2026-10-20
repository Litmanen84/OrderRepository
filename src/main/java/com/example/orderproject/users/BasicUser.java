package com.example.orderproject.users;

import com.example.orderproject.users.enums.Role;

public class BasicUser extends User {

    public BasicUser(String firstname, String lastname, String email, String password, Address address, PhoneNumber phoneNumber) {
        super(Role.USER, firstname, lastname, email, password, address, phoneNumber);
    }

}
