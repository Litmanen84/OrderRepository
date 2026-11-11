package com.example.orderproject.items;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

//    @LocalServerPort
//    private int port;
//    @Autowired
//    private ItemDB itemDB;
//    @Autowired
//    private UserDB userDB;
//
//    Admin admin;
//    String credentials;
//    String auth;
//    BasicUser user;
//    CreateItemsDTO correctDTO;
//    String badCredentials;
//    String badAuth;
//
//    @BeforeEach
//    void setUp() {
//        RestAssured.port = port;
//        itemDB.reset();
//        admin = userDB.getAdmin();
//        user = userDB.getBasicUser();
//        credentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
//        badCredentials = Base64.getEncoder().encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes(StandardCharsets.UTF_8));
//        auth = "Basic " + credentials;
//        badAuth = "Basic " + badCredentials;
//        correctDTO = new CreateItemsDTO(
//                "Oranges",
//                "Ciccio",
//                new BigDecimal("5.25"),
//                10
//        );
//    }
//
//    @Test
//    void createItemsWithCorrectDTOAndAuth_returnsCreated() {
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .body(correctDTO)
//                .post("/items")
//                .then()
//                .statusCode(201);
//    }
//
//    @Test
//    void createItemsWithoutAdminAuth_returns401() {
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", badAuth)
//                .body(correctDTO)
//                .post("/items")
//                .then()
//                .statusCode(401);
//    }
//
//    @Test
//    void createItemsWithoutAuth_returns401() {
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", "")
//                .body(correctDTO)
//                .post("/items")
//                .then()
//                .statusCode(401);
//    }
//
//    @Test
//    void createItemsWithIncorrectDTO_returns400Exception() {
//        CreateItemsDTO incorrectDTO = new CreateItemsDTO(
//                "",
//                "Ciccio",
//                new BigDecimal("5.25"),
//                10
//        );
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", auth)
//                .body(incorrectDTO)
//                .post("/items")
//                .then()
//                .statusCode(400);
//    }
}