package ru.netology.service;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class GetTest {
    @Test
    void shouldPostEURO() {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency: EURO")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("currency: ERO"))
        ;
    }

    @Test
    void shouldPostRusText() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("currency: Мяу")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("currency: Meow"))
        ;
    }
}