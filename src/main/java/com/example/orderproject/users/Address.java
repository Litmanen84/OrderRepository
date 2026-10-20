package com.example.orderproject.users;

import jakarta.validation.constraints.NotBlank;

public class Address {
    private String street;
    private int number;
    @NotBlank
    private String city;
    private String country;
    @NotBlank
    private String zipcode;

    public Address(String street, int number, String city, String country, String zipcode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }
}
