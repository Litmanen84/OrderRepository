package com.example.orderproject.users;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsersControllerTest {

//    @LocalServerPort
//    private int port;
//    @Autowired
//    private UserDB userDB;
//    @Autowired
//    private UserMapper mapp;
//
//    Admin admin;
//    String credentials;
//    String auth;
//    BasicUser user;
//    String badCredentials;
//    String badAuth;
//
//    @BeforeEach
//    void setUp() {
//        RestAssured.port = port;
//        userDB.reset();
//    }
//
//    @Test
//    void createBasicUserWithCorrectDTO_returnsCreated() throws Exception {
//
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "Ciccio",
//                "Pignatta",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(201);
//    }
//
//    @Test
//    void createBasicUserWithExistingEmail_returns401() throws Exception {
//
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "Ciccio",
//                "Pignatta",
//                "ciccio.magnotta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(409);
//    }
//
//    @Test
//    void createBasicUserWithMissingEmail_returnsBadRequest() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "Ciccio",
//                "Pignatta",
//                "",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    void createBasicUserWithWrongEmail_returnsBadRequest() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "Ciccio",
//                "Pignatta",
//                "ciccio.magnotta",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    void createBasicUserWithMissingFirstnameAndLastname_returnsCreated() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "",
//                "",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(201);
//    }
//
//    @Test
//    void createBasicUserWithWrongPhoneNumberFormat_returnsBadRequest() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "",
//                "",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "AA",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    void createBasicUserWithMissingZipCode_returnsBadRequest() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "",
//                "",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "Caserta",
//                        "Italy",
//                        ""
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    void createBasicUserWithMissingCity_returnsBadRequest() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "",
//                "",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "Via Vai",
//                        23,
//                        "",
//                        "Italy",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    void createBasicUserWithMissingAllNotNecessaryFields_returnsCreated() throws Exception {
//        CreateUserDTO createUserDTO = new CreateUserDTO(
//                "",
//                "",
//                "ciccio.andreatta@gmail.com",
//                "ciao123",
//                new Address(
//                        "",
//                         0,
//                        "Caserta",
//                        "",
//                        "81100"
//                ),
//                new PhoneNumber(
//                        "39",
//                        "347272924"
//                )
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .body(createUserDTO)
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(201);
//    }
//
//    @Test
//    void getAllUsersWithAuthReturnsOkStatus() {
//        admin = userDB.getAdmin();
//        credentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
//        auth = "Basic " + credentials;
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getAllUsersWithWrongAuthReturns401() {
//        auth = "Basic wrongCredentials";
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(401);
//    }
//
//    @Test
//    void getAllUsersWithoutAuthReturns401() {
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", "")
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(401);
//    }
//
//    @Test
//    void getUserDetailsWithAuthReturnsOkStatus() {
//        admin = userDB.getAdmin();
//        credentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
//        auth = "Basic " + credentials;
//        BasicUser user = userDB.getBasicUser();
//        UUID id = user.getId();
//
//        RestAssured
//                .given()
//                .pathParam("id", id)
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .when()
//                .get("/users/{id}")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getUserDetailsWithIncorrectIDReturnsNotFoundException() {
//        admin = userDB.getAdmin();
//        credentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
//        auth = "Basic " + credentials;
//        UUID wrongId = UUID.fromString("e58ed763-928c-4155-bee9-fdbaaadc15f3");
//
//        RestAssured
//                .given()
//                .pathParam("id", wrongId)
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .when()
//                .get("/users/{id}")
//                .then()
//                .statusCode(404);
//    }
//
//    @Test
//    void getUserDetailsWithoutAuthReturns401() {
//        BasicUser user = userDB.getBasicUser();
//        UUID id = user.getId();
//
//        RestAssured
//                .given()
//                .pathParam("id", id)
//                .contentType("application/json")
//                .header("Authorization", "")
//                .when()
//                .get("/users/{id}")
//                .then()
//                .statusCode(401);
//    }
//
//    @Test
//    void getUserDetailsWithWrongAuthReturns401() {
//        auth = "Basic wrongCredentials";
//        BasicUser user = userDB.getBasicUser();
//        UUID id = user.getId();
//
//        RestAssured
//                .given()
//                .pathParam("id", id)
//                .contentType("application/json")
//                .header("Authorization", "")
//                .when()
//                .get("/users/{id}")
//                .then()
//                .statusCode(401);
//    }
}