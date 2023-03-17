package options;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

abstract public class Specs {
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;

    @BeforeAll
    static void setUp() {

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", "0f938cbff9194b06be6c25f0799e9c3f")
                .addQueryParam("includeNutrition", "false")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }
}