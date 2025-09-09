package com.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTestGet {
    public void getExample() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("userId", equalTo(1))
            .log().all();
    }
}