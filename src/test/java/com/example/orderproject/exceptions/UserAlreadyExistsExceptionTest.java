package com.example.orderproject.exceptions;

import com.example.orderproject.users.exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAlreadyExistsExceptionTest {

    @Test
    void test() {
        UserAlreadyExistsException e = new UserAlreadyExistsException("test");
        assertEquals("test", e.getMessage());
    }

}