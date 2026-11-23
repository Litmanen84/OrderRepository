package com.example.orderproject.users.api.dtos;

public class UserGenericDetailsDTO {
    private final Integer id;
    private final String firstname;
    private final String lastname;
    private final String email;

    public UserGenericDetailsDTO(Integer id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Integer getId() {
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
}
