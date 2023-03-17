import io.restassured.response.Response;
import options.Specs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShoppingListTest extends Specs {

    @Test
    void addToShoppingListTest() {
        Response response = given()
                .spec(getRequestSpecification())
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .body("""
                        {
                        \t"item": "1 package baking powder",
                        \t"aisle": "Baking",
                        \t"parse": true
                        }""")
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items")
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response()
                .body()
                .as(Response.class);
    }

    @Test
    void getShoppingListTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .get("https://api.spoonacular.com/mealplanner/{username}/shopping-list")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void deleteTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("hash", "b50625841c1a1a630f2bfdc874798474f93e0ff2")
                .pathParam("username", "cool-user13")
                .pathParam("id", 1489039)
                .delete("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .spec(getResponseSpecification());
    }
}