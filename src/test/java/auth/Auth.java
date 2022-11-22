package auth;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.booker.TokenBody;
import org.testng.annotations.Test;
import utilities.RequestFilter;

import static org.hamcrest.Matchers.lessThan;

public class Auth extends BaseTest {
    @Test(groups = "Regression")
    public void getToken() {
        RestAssured.baseURI = baseUrl;
        var schemaFile = "token/token.json";
        var requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);

        var bookerRespond = new TokenBody();
        requestSpecification.body(bookerRespond);

        requestSpecification.filter(new RequestFilter());
        requestSpecification.basePath("auth");

        var response = requestSpecification.request(Method.POST);

        var responsebody = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(schemaFile)));
    }
}
