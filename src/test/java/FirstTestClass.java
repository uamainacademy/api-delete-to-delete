import io.restassured.RestAssured;
import models.login.LoginRequestModel;
import models.login.LoginResponseModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class FirstTestClass extends BaseTest {


  @Test
  public void loginTest() {

    LoginRequestModel requestModel = new LoginRequestModel("hbingley1", "CQutx25i8r");

    LoginResponseModel loginResponseModel = RestAssured
        .given()
        .body(requestModel)
        .post("/auth/login")
        .then()
        .statusCode(200)
        .extract()
        .body()
        .as(LoginResponseModel.class);

    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(loginResponseModel.getId())
        .as("[id] not as expected")
        .isEqualTo(2);
    softly.assertThat(loginResponseModel.getUsername())
        .as("[user] not as expected")
        .isEqualTo("hbingley1");
    softly.assertThat(loginResponseModel.getImage())
        .as("[image] not as expected")
        .startsWith("https://")
        .endsWith(".png");
    softly.assertThat(loginResponseModel.getToken())
        .as("[token] not as expected")
        .isNull();

    softly.assertAll();

  }

}
