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
    @Test
    public void getToken() {
        RestAssured.baseURI = baseUrl;
        var schemaFile = "token/token.json";
        var requesSpecification = RestAssured.given();
        requesSpecification.contentType(ContentType.JSON);

        /*var authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password123");*/

        var bookerRespond = new TokenBody();
        requesSpecification.body(bookerRespond);

        requesSpecification.filter(new RequestFilter());
        requesSpecification.basePath("auth");

        var response = requesSpecification.request(Method.POST);

        var responsebody = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(schemaFile)));
    }

}
