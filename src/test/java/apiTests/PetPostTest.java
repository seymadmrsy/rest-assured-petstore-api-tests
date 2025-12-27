package apiTests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetPostTest {

    @Test
    public void createPetTest() {

        // Base URI
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Request Body
        String requestBody = "{\n" +
                "  \"id\": 20252026,\n" +
                "  \"name\": \"Şeyma\",\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)      // Header
                .accept(ContentType.JSON)
                .body(requestBody)                  // Body
                .when()
                .post("/pet")                      // Endpoint
                .then()
                .statusCode(200)                    // Assertion 1
                .body("id", equalTo(20252026))        // Assertion 2
                .body("name", equalTo("Şeyma"))     // Assertion 3
                .body("status", equalTo("available"));
    }
}
