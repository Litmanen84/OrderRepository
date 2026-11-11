package com.example.orderproject.users.domain;

import com.example.orderproject.orders.domain.Orders;
import com.example.orderproject.users.domain.persondetails.Address;
import com.example.orderproject.users.domain.persondetails.enums.Feature;
import com.example.orderproject.users.domain.persondetails.enums.Role;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", nullable = false)
    private String firstname;
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;
    @Embedded
    private Address address;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public User(String firstname, String lastname, String email, String hashedPassword, Address address, String phoneNumber, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public boolean canHaveAccessTo(Feature feature){
        return role.hasFeature(feature);
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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}