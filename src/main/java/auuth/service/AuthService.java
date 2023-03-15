package auuth.service;

import auuth.models.AuthResponseModel;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class AuthService {

  @Step("Login and get token")
  public String loginAndGetToken() {
    return RestAssured
        .given()
        .filter(new RequestLoggingFilter())
        .filter(new ResponseLoggingFilter())
        .filter(new AllureRestAssured())
        .contentType("application/x-www-form-urlencoded")
        .formParam("scope", "offline_access")
        .formParam("grant_type", "password")
        .formParam("username", "api-user4@iwt.net")
        .formParam("password", "b3z0nV0cLO")
        .formParam("client_id", "0oahdhjkutaGcIK2M4x6")
        .post("https://dev-457931.okta.com/oauth2/aushd4c95QtFHsfWt4x6/v1/token")
        .then()
        .statusCode(200)
        .extract()
        .body().as(AuthResponseModel.class).getAccessToken();


  }

}
