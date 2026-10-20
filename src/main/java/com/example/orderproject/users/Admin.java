package com.example.orderproject.users;

import com.example.orderproject.users.enums.Role;

public class Admin extends User {
    private Role role;

    public Admin(String firstname, String lastname, String email, String password, Address address, PhoneNumber phoneNumber) {
        super(Role.ADMIN, firstname, lastname, email, password, address, phoneNumber);
    }

}
