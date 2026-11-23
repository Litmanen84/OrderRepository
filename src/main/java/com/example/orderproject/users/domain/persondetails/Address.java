package com.example.orderproject.users.domain.persondetails;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Address {
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private String number;
    @NotBlank
    @Column(name = "city", nullable = false)
    private String city;
    @NotBlank
    @Column(name = "zip_code", nullable = false)
    private String zipcode;

    public Address(String street, String number, String city, String zipcode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipcode = zipcode;
    }
    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
