
package com.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTestGet {

    @Test
    public void testGetUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .log().all()
        .when()
            .get("/users/1")   // valid endpoint
        .then()
            .log().all()
            .statusCode(200)   // JSONPlaceholder always returns 200 for valid resources
            .body("id", equalTo(1))
            .body("username", notNullValue());
    }
}