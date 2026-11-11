package com.example.orderproject.exceptions;

import com.example.orderproject.common.exceptions.ItemAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemAlreadyExistsExceptionTest {

    @Test
    void test() {
        ItemAlreadyExistsException e = new ItemAlreadyExistsException("test");
        assertEquals("test", e.getMessage());
    }
}