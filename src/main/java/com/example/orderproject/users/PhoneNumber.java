package com.example.orderproject.users;

import jakarta.validation.constraints.*;

public class PhoneNumber {
    @NotBlank
    @Size(min = 2, max = 3)
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
    @Size(min = 6, max = 9)
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
