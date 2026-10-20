package com.example.orderproject.users;

import com.example.orderproject.users.enums.Role;

import java.util.UUID;

public abstract class GeneralUser {
    private UUID id;
    private Role role;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Address address;
    private PhoneNumber phoneNumber;

    public GeneralUser(Role role, String firstname, String lastname, String email, String password, Address address, PhoneNumber phoneNumber) {
        this.id = UUID.randomUUID();
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}