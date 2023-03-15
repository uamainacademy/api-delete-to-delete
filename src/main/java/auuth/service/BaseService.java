package auuth.service;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseService {

  public RequestSpecification getRequestSpec() {
    return new RequestSpecBuilder()
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .addFilter(new AllureRestAssured())
        .setBaseUri("https://api.instantwebtools.net/v2")
        .setContentType(ContentType.JSON)
        .setAccept(ContentType.JSON)
        .build();
  }
}
