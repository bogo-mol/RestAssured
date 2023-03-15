import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchRecipesTest {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    void postOneTest() {
        given()
                .queryParam("language", "en")
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("Greek-Style Baked Fish: Fresh, Simple, and Delicious")
                .body("fish")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    void postTwoTest() {
        given()
                .queryParam("language", "en")
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("Vegetarian Mushroom Shepherd's Pie")
                .body("mushroom")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    void postThreeTest() {
        given()
                .queryParam("language", "en")
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("Spinach Goats Cheese Roulade Main Dish")
                .body("cheese")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    void postFourTest() {
        given()
                .queryParam("language", "en")
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("Red Wine Braised Beef Brisket")
                .body("wine")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    void postFiveTest() {
        given()
                .queryParam("language", "en")
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("Chicken Fajita Stuffed Bell Pepper")
                .body("pepper")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
}