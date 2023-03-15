import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ComplexSearchTest {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    void getCuisine() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("cuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void getExcludeCuisine() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("excludeCuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void getDietList() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("diet", "Vegeterian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void getIntolerancesList() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("intolerances", "gluten")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void getTypeList() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("type", "soup")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}