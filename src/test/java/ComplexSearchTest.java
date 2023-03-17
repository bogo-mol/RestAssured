import options.Specs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ComplexSearchTest extends Specs {

    @Test
    void getCuisine() {
        given()
                .spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void getExcludeCuisine() {
        given()
                .spec(getRequestSpecification())
                .queryParam("excludeCuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void getDietList() {
        given()
                .spec(getRequestSpecification())
                .queryParam("diet", "Vegeterian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void getIntolerancesList() {
        given()
                .spec(getRequestSpecification())
                .queryParam("intolerances", "gluten")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void getTypeList() {
        given()
                .spec(getRequestSpecification())
                .queryParam("type", "soup")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(getResponseSpecification());
    }
}