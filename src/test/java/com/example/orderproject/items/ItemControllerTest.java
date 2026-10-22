package com.example.orderproject.items;

import com.example.orderproject.databases.ItemDB;
import com.example.orderproject.databases.UserDB;
import com.example.orderproject.items.dtos.CreateItemsDTO;
import com.example.orderproject.users.Admin;
import com.example.orderproject.users.BasicUser;
import com.example.orderproject.users.User;
import com.example.orderproject.users.UserController;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private ItemDB itemDB;
    @Autowired
    private UserDB userDB;

    Admin admin;
    String credentials;
    String auth;
    BasicUser user;
    CreateItemsDTO correctDTO;
    String badCredentials;
    String badAuth;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        itemDB.reset();
        admin = userDB.getAdmin();
        user = userDB.getBasicUser();
        credentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
        badCredentials = Base64.getEncoder().encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes(StandardCharsets.UTF_8));
        auth = "Basic " + credentials;
        badAuth = "Basic " + badCredentials;
        correctDTO = new CreateItemsDTO(
                "Oranges",
                "Ciccio",
                new BigDecimal("5.25"),
                10
        );
    }

    @Test
    void createItemsWithCorrectDTOAndAuth_returnsCreated() {
        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", auth)
                .body(correctDTO)
                .post("/items")
                .then()
                .statusCode(201);
    }

    @Test
    void createItemsWithoutAdminAuth_returns401() {
        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", badAuth)
                .body(correctDTO)
                .post("/items")
                .then()
                .statusCode(401);
    }

    @Test
    void createItemsWithoutAuth_returns401() {
        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", "")
                .body(correctDTO)
                .post("/items")
                .then()
                .statusCode(401);
    }

    @Test
    void createItemsWithIncorrectDTO_returns400Exception() {
        CreateItemsDTO incorrectDTO = new CreateItemsDTO(
                "",
                "Ciccio",
                new BigDecimal("5.25"),
                10
        );

        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", auth)
                .body(incorrectDTO)
                .post("/items")
                .then()
                .statusCode(400);
    }
}