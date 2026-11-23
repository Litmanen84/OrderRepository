package com.example.orderproject.users.api;

import com.example.orderproject.users.api.dtos.CreateUserDTO;
import com.example.orderproject.users.domain.User;
import com.example.orderproject.users.domain.persondetails.Address;
import com.example.orderproject.users.domain.persondetails.enums.Role;
import com.example.orderproject.users.repositories.UserRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UsersControllerTest {
    private static final String USER_NAME = "ciccio";
    private static final String USER_LASTNAME = "magnotta";
    private static final String USER_EMAIL = "ciccio@magnottello.it";
    private static final String USER_PASSWORD = "ciao123";
    private static final Address USER_ADDRESS = new Address(
            "Via vai",
            "23",
            "Caserta",
            "81100"
    );
    private static final String USER_PHONE = "393472729";
    private static final String ADMIN_CREDENTIALS = "test-admin@example.com:test-admin-password";
    private static String auth;

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepo;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @AfterEach
    void tearDown() {
        userRepo.deleteByRole(Role.USER);
    }

    @Test
    void createBasicUserWithCorrectDTO_returnsCreated() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    void createBasicUserWithExistingEmail_returns409_CONFLICT() throws Exception {

        CreateUserDTO existingUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(existingUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

        CreateUserDTO newUser = new CreateUserDTO(
                "Armando",
                "Iodice",
                USER_EMAIL,
                "Collirio",
                USER_ADDRESS,
                "123423124"
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(409);
    }


    @Test
    void createBasicUserWithMissingEmail_returnsBadRequest() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                "",
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithWrongEmail_returnsBadRequest() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                "ciccioemail.it",
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingFirstname_returnsBadRequest400() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                "",
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingLastname_returnsBadRequest400() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                "",
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithWrongPhoneNumberFormat_returnsBadRequest() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                "123A4567"
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingZipCode_returnsBadRequest() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                new Address(
                        "Via vai",
                        "23",
                        "Caserta",
                        ""
                ),
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingCity_Returns400BadRequest() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                new Address(
                        "Via vai",
                        "23",
                        "",
                        "81100"
                ),
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    void createBasicUserWithMissingAllNotNecessaryFields_returnsCreated() throws Exception {
        CreateUserDTO newUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                new Address(
                        "",
                        "",
                        "Caserta",
                        "81100"
                ),
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    void getAllUsersWithAuthReturnsOkStatus() {
        auth = "Basic " + Base64.getEncoder()
                .encodeToString(ADMIN_CREDENTIALS.getBytes(StandardCharsets.UTF_8));

        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", auth)
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    void getAllUsersWithWrongAuthReturns401() {
        auth = "Basic wrongCredentials";

        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", auth)
                .when()
                .get("/users")
                .then()
                .statusCode(401);
    }

    @Test
    void getAllUsersWithoutAuthReturns401() {
        RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", "")
                .when()
                .get("/users")
                .then()
                .statusCode(401);
    }

    @Test
    void getUserDetailsWithAuthReturnsOkStatus() {
        auth = "Basic " + Base64.getEncoder()
                .encodeToString(ADMIN_CREDENTIALS.getBytes(StandardCharsets.UTF_8));

        CreateUserDTO existingUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(existingUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

        User userToFind = userRepo.findByEmail(USER_EMAIL)
                .orElseThrow();

        RestAssured
                .given()
                .pathParam("id", userToFind.getId())
                .contentType("application/json")
                .header("Authorization", auth)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    void getUserDetailsWithIncorrectIDReturnsNotFoundException() {
        auth = "Basic " + Base64.getEncoder()
                .encodeToString(ADMIN_CREDENTIALS.getBytes(StandardCharsets.UTF_8));

        CreateUserDTO existingUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(existingUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

        User userToFind = userRepo.findByEmail(USER_EMAIL)
                .orElseThrow();

        Integer wrongId = userToFind.getId() + 1;

        RestAssured
                .given()
                .pathParam("id", wrongId)
                .contentType("application/json")
                .header("Authorization", auth)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    void getUserDetailsWithoutAuthReturns401() {
        CreateUserDTO existingUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(existingUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

        User userToFind = userRepo.findByEmail(USER_EMAIL)
                .orElseThrow();

        RestAssured
                .given()
                .pathParam("id", userToFind.getId())
                .contentType("application/json")
                .header("Authorization", "")
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(401);
    }

    @Test
    void getUserDetailsWithWrongAuthReturns401() {
        auth = "Basic wrongCredentials";

        CreateUserDTO existingUser = new CreateUserDTO(
                USER_NAME,
                USER_LASTNAME,
                USER_EMAIL,
                USER_PASSWORD,
                USER_ADDRESS,
                USER_PHONE
        );

        RestAssured
                .given()
                .contentType("application/json")
                .body(existingUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

        User userToFind = userRepo.findByEmail(USER_EMAIL)
                .orElseThrow();

        RestAssured
                .given()
                .pathParam("id", userToFind.getId())
                .contentType("application/json")
                .header("Authorization", auth)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(401);
    }
}