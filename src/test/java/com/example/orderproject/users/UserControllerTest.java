package com.example.orderproject.users;

import com.example.orderproject.databases.UserDB;
import com.example.orderproject.users.dtos.CreateUserDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private UserDB userDB;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        userDB.reset();
    }

    @Test
    void createBasicUserWithCorrectDTO_returnsCreated() throws Exception {

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

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    void createBasicUserWithExistingEmail_returns401() throws Exception {

        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Pignatta",
                "ciccio.magnotta@gmail.com",
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

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(409);
    }

    @Test
    void createBasicUserWithMissingEmail_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Pignatta",
                "",
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

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithWrongEmail_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Pignatta",
                "ciccio.magnotta",
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

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingFirstnameAndLastname_returnsCreated() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
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

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    void createBasicUserWithWrongPhoneNumberFormat_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
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
                        "AA",
                        "347272924"
                )
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingZipCode_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.andreatta@gmail.com",
                "ciao123",
                new Address(
                        "Via Vai",
                        23,
                        "Caserta",
                        "Italy",
                        ""
                ),
                new PhoneNumber(
                        "39",
                        "347272924"
                )
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingCity_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.andreatta@gmail.com",
                "ciao123",
                new Address(
                        "Via Vai",
                        23,
                        "",
                        "Italy",
                        "81100"
                ),
                new PhoneNumber(
                        "39",
                        "347272924"
                )
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingAllNotNecessaryFields_returnsCreated() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.andreatta@gmail.com",
                "ciao123",
                new Address(
                        "",
                         0,
                        "Caserta",
                        "",
                        "81100"
                ),
                new PhoneNumber(
                        "39",
                        "347272924"
                )
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(createUserDTO)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }
}