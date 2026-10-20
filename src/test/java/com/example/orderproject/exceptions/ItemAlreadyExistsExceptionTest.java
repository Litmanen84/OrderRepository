package com.example.orderproject.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemAlreadyExistsExceptionTest {

    @Test
    void test() {
        ItemAlreadyExistsException e = new ItemAlreadyExistsException("test");
        assertEquals("test", e.getMessage());
    }
}