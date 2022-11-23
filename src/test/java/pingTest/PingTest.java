package pingTest;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class PingTest extends BaseTest {
    @Test(groups = "Smoke")
    public void pingTest() {
        RestAssured.baseURI = baseUrl;
        var requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);

        var response = requestSpecification.get("ping");

        response.then().assertThat()
                .statusCode(201)
                .time(lessThan(4000L));
    }
}
