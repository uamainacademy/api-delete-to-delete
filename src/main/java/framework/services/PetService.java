package framework.services;

import static framework.Endpoints.PET_BY_ID;
import static io.restassured.RestAssured.given;

import framework.models.pet.PetNotificationResponseModel;
import framework.models.pet.PetModel;
import io.restassured.response.ValidatableResponse;

public class PetService {

  private ValidatableResponse getPetByIdResponse(int id) {
    return given()
        .pathParam("id", id)
        .get(PET_BY_ID)
        .then();
  }

  public PetModel getPetById(int id) {
    return getPetByIdResponse(id)
        .statusCode(200)
        .extract()
        .body()
        .as(PetModel.class);
  }

  public PetNotificationResponseModel getNotExistedPet(int id) {
    return getPetByIdResponse(id)
        .statusCode(404)
        .extract()
        .body()
        .as(PetNotificationResponseModel.class);
  }


  public PetNotificationResponseModel deletePet(int id) {
    return given()
        .pathParam("id", id)
        .delete(PET_BY_ID)
        .then()
        .statusCode(200)
        .extract()
        .body()
        .as(PetNotificationResponseModel.class);
  }

}
