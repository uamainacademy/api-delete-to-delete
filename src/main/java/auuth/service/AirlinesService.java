package auuth.service;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;

public class AirlinesService extends BaseService {

  @Step("Get all air lines")
  public void getAllAirLines(String token) {
    given()
        .spec(getRequestSpec())
        .header("Authorization", "Bearer " + token)
        .get("/airlines")
        .then()
        .statusCode(200);
  }

  @Step("Get air lines by id")
  public void getAirLinesById(String token, int id) {
    given()
        .spec(getRequestSpec())
        .pathParam("id",id)
        .header("Authorization", "Bearer " + token)
        .get("/airlines/{id}")
        .then()
        .statusCode(200);
  }

}
