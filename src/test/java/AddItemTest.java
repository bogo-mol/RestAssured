import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddItemTest {
    //@BeforeAll
    @Test
     void setUp() {
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
        RestAssured.filters(new AllureRestAssured());
        given()
                .queryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .queryParam("includeNutrition", "true")
                .pathParam("username", "cool-user13")
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items");
    }
}
