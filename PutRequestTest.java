package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest {

    @Test
    public void testUpdatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"updated title\",\n" +
                "  \"body\": \"updated body\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
            .header("Content-type", "application/json")
            .and()
            .body(requestBody)
            .log().all()
        .when()
            .put("/posts/1")  // valid PUT endpoint
        .then()
            .log().all()
            .statusCode(200)   // JSONPlaceholder returns 200 for PUT
            .body("title", equalTo("updated title"))
            .body("body", equalTo("updated body"));
    }
}
