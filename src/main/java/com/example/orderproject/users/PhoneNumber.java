package com.example.orderproject.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PhoneNumber {
    @NotBlank
    @Pattern(
            regexp = "^[0-9]+$",
            message = "Prefix must have only numbers"
    )
    private String prefix;
    @NotBlank
    @Pattern(
            regexp = "^[0-9]+$",
            message = "Phone number must have only numbers"
    )
    private String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }
    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }
}
