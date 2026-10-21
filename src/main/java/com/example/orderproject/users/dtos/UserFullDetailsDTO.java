package com.example.orderproject.users.dtos;

import com.example.orderproject.users.Address;
import com.example.orderproject.users.PhoneNumber;
import com.example.orderproject.users.enums.Role;

import java.util.UUID;

public class UserFullDetailsDTO {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final Role role;

    public UserFullDetailsDTO(UUID id, String firstname, String lastname, String email, Address address, PhoneNumber phoneNumber, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }
}
