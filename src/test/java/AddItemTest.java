import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddItemTest {
    @BeforeAll

    static void setUp() {
        RestAssured.filters(new AllureRestAssured());
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .body("{ \"username\": \"cool user\", }")
                .when()
                .post("https://api.spoonacular.com/users/connect");
    }

    @Test
    void addItemTest() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .body("{\n" +
                        "\t\"item\": \"1 package baking powder\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

   /* @Test
    void getShoppingListTest() {
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .get("https://api.spoonacular.com/mealplanner/{username}/shopping-list");
    }*/

    @Test
    void teamDown() {
        given()
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .pathParam("id", 1488393)
                .delete("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items/{id}");
    }
}