import options.Specs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchRecipesTest extends Specs {

    @Test
    void postOneTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("language", "en")
                .body("Greek-Style Baked Fish: Fresh, Simple, and Delicious")
                .body("fish")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void postTwoTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("language", "en")
                .body("Vegetarian Mushroom Shepherd's Pie")
                .body("mushroom")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void postThreeTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("language", "en")
                .body("Spinach Goats Cheese Roulade Main Dish")
                .body("cheese")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void postFourTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("language", "en")
                .body("Red Wine Braised Beef Brisket")
                .body("wine")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void postFiveTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("language", "en")
                .body("Chicken Fajita Stuffed Bell Pepper")
                .body("pepper")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(getResponseSpecification());
    }
}