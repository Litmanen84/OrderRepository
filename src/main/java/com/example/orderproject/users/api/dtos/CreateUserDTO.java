package com.example.orderproject.users.api.dtos;

import com.example.orderproject.users.domain.persondetails.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateUserDTO {

    @NotBlank
    final private String firstname;
    @NotBlank
    final private String lastname;
    @NotBlank
    @Email
    @Pattern(
            regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$",
            message = "Email must have the form x@x.x using only letters and numbers"
    )
    final private String email;
    @NotBlank
    private String password;
    @Valid
    @NotNull
    final private Address address;
    @NotBlank
    private String phoneNumber;

    public CreateUserDTO(String firstname, String lastname, String email, String password, Address address, String phoneNumber) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
