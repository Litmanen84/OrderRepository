package com.example.orderproject.orders;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {
    @LocalServerPort
    private int port;

//    @Autowired
//    private UserDB userDB;
//
//    @Autowired
//    private ItemDB itemDB;
//
//    Admin admin;
//    String adminCredentials;
//    String adminAuth;
//    BasicUser user;
//    String userCredentials;
//    String userAuth;
//
//    @BeforeEach
//    void setUp() {
//        RestAssured.port = port;
//        admin = userDB.getAdmin();
//        user = userDB.getBasicUser();
//        adminCredentials = Base64.getEncoder().encodeToString((admin.getEmail() + ":" + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
//        userCredentials = Base64.getEncoder().encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes(StandardCharsets.UTF_8));
//        adminAuth = "Basic " + adminCredentials;
//        userAuth = "Basic " + userCredentials;
//    }
//
//    @Test
//    void createOrderCorrectlyCreatesOrder() {
//        itemDB.reset();
//        Item item = itemDB.getTestItem();
//        UUID itemId = item.getId();
//        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(itemId, 3);
//        CreateOrderDTO correctDTO = new CreateOrderDTO(List.of(createItemGroupDTO));
//
//        RestAssured
//                .given()
//                .contentType("application/json")
//                .header("Authorization", userAuth)
//                .body(correctDTO)
//                .post("/orders")
//                .then()
//                .statusCode(201);
//    }
}