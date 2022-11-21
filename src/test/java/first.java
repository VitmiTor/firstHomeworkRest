import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.booker.BookerCreateResponse;
import models.booker.BookerResponse;
import org.testng.annotations.Test;
import utilities.RequestFilter;

import static org.hamcrest.Matchers.lessThan;

public class first extends BaseTest {


    @Test
    public void secondTest() {
        var id = 1366;
        var schemaJson = "booker/bookerSchema.json";

        RestAssured.baseURI = baseUrl;
        var requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.filter(new RequestFilter());
        requestSpecification.pathParams("bookerID", id);

        requestSpecification.basePath("booking/{bookerID}");

        var response = requestSpecification.request(Method.GET);


        response.then().assertThat()
                .statusCode(200)
                .time(lessThan(4000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(schemaJson)));

    }

    @Test
    public void deleteTest() {
        var id = 1919;

        RestAssured.baseURI = baseUrl;
        var requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.auth().preemptive().basic("admin", "password123");

        requestSpecification.filter(new RequestFilter());
        requestSpecification.pathParams("bookerID", id);

        requestSpecification.basePath("booking/{bookerID}");

        var response = requestSpecification.request(Method.DELETE);


        response.then().assertThat()
                .statusCode(201)
                .time(lessThan(4000L));
    }


    @Test
    public void createBookerTest() {
        RestAssured.baseURI = baseUrl;
        var schemaFile = "booker/createBookerSchema.json";
        var requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);

        var authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password123");

        var bookerRequestBody = new BookerResponse();
        requestSpecification.body(bookerRequestBody);

        RestAssured.authentication = authScheme;
        requestSpecification.filter(new RequestFilter());

        requestSpecification.basePath("booking");
        var response = requestSpecification.request(Method.POST);

        var responsebody = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(schemaFile)))
                .extract().body().as(BookerCreateResponse.class);

        logs.info("The response id is: " + String.valueOf(responsebody.getBookingID()));

        bookerRequestBody.isEqualsTo(responsebody.getBookerResponse());
        responsebody.getBookerResponse();
    }
}
