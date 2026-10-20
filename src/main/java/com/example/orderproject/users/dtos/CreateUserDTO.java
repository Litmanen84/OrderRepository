package com.example.orderproject.users.dtos;

import com.example.orderproject.users.Address;
import com.example.orderproject.users.PhoneNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateUserDTO {

    private String firstname;
    private String lastname;
    @NotBlank
    @Email
    @Pattern(
            regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$",
            message = "Email must have the form x@x.x using only letters and numbers"
    )
    private String email;
    @NotBlank
    private String password;
    @Valid
    private Address address;
    @Valid
    private PhoneNumber phoneNumber;

    public CreateUserDTO(String firstname, String lastname, String email, String password, Address address, PhoneNumber phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
