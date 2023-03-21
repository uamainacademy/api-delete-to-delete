package mypackage;

import auuth.service.AirlinesService;
import auuth.service.AuthService;
import org.testng.annotations.Test;

public class AuthTests {

  private final AuthService authService = new AuthService();
  private final AirlinesService airlinesService = new AirlinesService();

  private String token;


  @Test
  public void getAllAitLines() {
    token = authService.loginAndGetToken();
    airlinesService.getAirLinesById(token, 3);
  }

}
