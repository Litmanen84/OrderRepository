package com.example.orderproject.users.mappers;

import com.example.orderproject.users.Address;
import com.example.orderproject.users.PhoneNumber;
import com.example.orderproject.users.User;
import com.example.orderproject.users.dtos.CreateUserDTO;
import com.example.orderproject.users.dtos.UserFullDetailsDTO;
import com.example.orderproject.users.dtos.UserGenericDetailsDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    UserMapper userMapper = new UserMapper();
    CreateUserDTO createUserDTO = new CreateUserDTO(
            "Ciccio",
            "Pignatta",
            "ciccio.andreatta@gmail.com",
            "ciao123",
            new Address(
                    "Via Vai",
                    23,
                    "Caserta",
                    "Italy",
                    "81100"
            ),
            new PhoneNumber(
                    "39",
                    "347272924"
            )
    );

    @Test
    void fromCreateUserDtoToUserCreatesUser() {
        User user = userMapper.fromCreateUserDtoToUser(createUserDTO);
        assertNotNull(user);
        assertAll(
                () -> assertEquals(user.getFirstname(), createUserDTO.getFirstname()),
                () -> assertEquals(user.getLastname(), createUserDTO.getLastname()),
                () -> assertEquals(user.getEmail(), createUserDTO.getEmail()),
                () -> assertEquals((user.getAddress()), (createUserDTO.getAddress())),
                () -> assertEquals((user.getPhoneNumber()), (createUserDTO.getPhoneNumber())),
                () -> assertEquals(user.getPassword(), createUserDTO.getPassword()),
                () -> assertEquals("User", user.getRole().getRole())
        );
    }

    @Test
    void fromUserToGenericDetails() {
        User user = userMapper.fromCreateUserDtoToUser(createUserDTO);
        UserGenericDetailsDTO userGenericDetailsDTO = userMapper.fromUserToGenericDetails(user);
        assertNotNull(userGenericDetailsDTO);
        assertAll(
                () -> assertEquals(user.getFirstname(), userGenericDetailsDTO.getFirstname()),
                () -> assertEquals(user.getLastname(), userGenericDetailsDTO.getLastname()),
                () -> assertEquals(user.getEmail(), userGenericDetailsDTO.getEmail()),
                () -> assertEquals(user.getId(), userGenericDetailsDTO.getId())
                );
    }

    @Test
    void fromUserToUserFullDetails() {
        User user = userMapper.fromCreateUserDtoToUser(createUserDTO);
        UserFullDetailsDTO userFullDetailsDTO = userMapper.fromUserToUserFullDetails(user);
        assertNotNull(userFullDetailsDTO);
        assertAll(
                () -> assertEquals(user.getId(), userFullDetailsDTO.getId()),
                () -> assertEquals(user.getFirstname(), userFullDetailsDTO.getFirstname()),
                () -> assertEquals(user.getLastname(), userFullDetailsDTO.getLastname()),
                () -> assertEquals(user.getEmail(), userFullDetailsDTO.getEmail()),
                () -> assertEquals((user.getAddress()), (userFullDetailsDTO.getAddress())),
                () -> assertEquals((user.getPhoneNumber()), (userFullDetailsDTO.getPhoneNumber())),
                () -> assertEquals("User", userFullDetailsDTO.getRole().getRole())
        );
    }
}