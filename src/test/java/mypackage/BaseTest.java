package mypackage;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class BaseTest {

  static {
    RestAssured.requestSpecification = new RequestSpecBuilder()
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .setBaseUri("https://petstore.swagger.io/v2")
        .setContentType(ContentType.JSON)
        .setAccept(ContentType.JSON)
        .build();
  }

}
