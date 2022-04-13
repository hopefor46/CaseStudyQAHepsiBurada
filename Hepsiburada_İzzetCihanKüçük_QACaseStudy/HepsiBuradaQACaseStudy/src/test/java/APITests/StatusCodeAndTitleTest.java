package APITests;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeAndTitleTest {

    @Test
    public void APITest() {
        RestAssured.baseURI = "https://httpbin.org";
        String response = given().header("Content-Type", "application/json").
                when().get("/json").
                then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String title = js.get("slideshow.slides.title[0]");
        boolean isEmpty = title.isBlank();
        Assert.assertFalse(isEmpty);
        Assert.assertEquals("Wake up to WonderWidgets!", title);


    }
}
