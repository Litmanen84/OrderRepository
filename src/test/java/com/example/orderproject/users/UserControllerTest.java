package com.example.orderproject.users;

import com.example.orderproject.users.dtos.CreateUserDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createUserWithCorrectDTO_returnsCreated() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Magnotta",
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
                .statusCode(201);
    }

    @Test
    void createUserWithMissingEmail_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Magnotta",
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
    void createUserWithWrongEmail_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "Ciccio",
                "Magnotta",
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
    void createUserWithMissingFirstnameAndLastname_returnsCreated() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
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
                .statusCode(201);
    }

    @Test
    void createUserWithWrongPhoneNumberFormat_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
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
    void createUserWithMissingZipCode_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.magnotta@gmail.com",
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
    void createUserWithMissingCity_returnsBadRequest() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.magnotta@gmail.com",
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
    void createUserWithMissingAllNotNecessaryFields_returnsCreated() throws Exception {
        CreateUserDTO createUserDTO = new CreateUserDTO(
                "",
                "",
                "ciccio.magnotta@gmail.com",
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