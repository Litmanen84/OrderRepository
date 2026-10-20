package com.example.orderproject.items.dtos;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateItemsDTOTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    void constructorCreatesAValidItem(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("5.25"),
                7
        );
        assertNotNull(item);
        assertAll(
                () -> assertEquals("Orange", item.getName()),
                () -> assertEquals("Ciccio", item.getDescription()),
                () -> assertEquals(new BigDecimal("5.25"), item.getPrice()),
                () -> assertEquals(7, item.getAmount())
        );
    }

    @Test
    void constructorWithMissingNameProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "",
                "Ciccio",
                new BigDecimal("5.25"),
                7
        );

        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("name"))
        );
    }

    @Test
    void constructorWithMissingPriceProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                null,
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("price"))
        );
    }

    @Test
    void constructorWithMissingAmountProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("5.25"),
                0
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("amount"))
        );
    }

    @Test
    void constructorWithNegativeAmountProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("5.25"),
                -1
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("amount"))
        );
    }

    @Test
    void constructorWithZeroAmountProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("5.25"),
                0
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("amount"))
        );
    }

    @Test
    void constructorWithNullDescriptionProducesNoViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                null,
                new BigDecimal("5.25"),
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void constructorWithMoreThanTwoDecimalsProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("5.256"),
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("price"))
        );
    }

    @Test
    void constructorWithNegativePriceProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("-5.25"),
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("price"))
        );
    }

    @Test
    void constructorWithPriceZeroProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("0.00"),
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("price"))
        );
    }

    @Test
    void constructorWithPriceMoreThanFourDigitsProducesViolation(){
        CreateItemsDTO item = new CreateItemsDTO(
                "Orange",
                "Ciccio",
                new BigDecimal("10000.00"),
                7
        );
        Set<ConstraintViolation<CreateItemsDTO>> violations =
                validator.validate(item);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream().
                anyMatch(v -> v.getPropertyPath().toString().equals("price"))
        );
    }

}