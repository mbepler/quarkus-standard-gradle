package app;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingResourceTest {

  @Test
  void testHelloEndpoint() {
    given()
        .when()
        .get("/hello")
        .then()
        .statusCode(200)
        .body(
            is(
                "[{\"id\":2,\"name\":\"Apple\"},{\"id\":3,\"name\":\"Banana\"},{\"id\":1,\"name\":\"Cherry\"}]"));
  }
}
