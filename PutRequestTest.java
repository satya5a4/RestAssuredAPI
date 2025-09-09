
package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest {

    // Example GET test
    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .when()
            .get("/users/1")
            .then()
            .statusCode(200)
            .body("username", equalTo("Bret"));  // Validate a field
    }

    // Example PUT test
    @Test
    public void testUpdatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .header("Content-type", "application/json")
            .body("{\"id\":1,\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}")
            .when()
            .put("/posts/1")
            .then()
            .statusCode(200)
            .body("title", equalTo("foo"));
    }
}