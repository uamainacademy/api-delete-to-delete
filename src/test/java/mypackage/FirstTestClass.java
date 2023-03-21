package mypackage;

import framework.models.pet.PetModel.Category;
import framework.models.pet.PetModel.Tag;
import framework.models.pet.PetNotificationResponseModel;
import framework.models.pet.PetModel;
import framework.services.PetService;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class FirstTestClass extends BaseTest {

  private final PetService petService = new PetService();

  @Test
  public void getExistedDogTest() {

    PetModel petResponse = petService.getPetById(30);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(petResponse.getName())
        .as("Dog name should be [Ricoboy]")
        .isEqualTo("Ricoboy");
    softly.assertAll();
  }


  @Test
  public void getNotExistedDogTest() {

    PetNotificationResponseModel notExistedPet = petService.getNotExistedPet(90);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(notExistedPet.getMessage())
        .as("Message should be [Pet not found]")
        .isEqualTo("Pet not found");
    softly.assertAll();
  }

  @Test
  public void getExistedDogTest2() {

    PetModel petResponse = petService.getPetById(3);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(petResponse.getName())
        .as("Dog name should be [doggie]")
        .isEqualTo("doggie");
    softly.assertAll();
  }

  @Test
  public void deletePetByIdTest() {
    PetNotificationResponseModel responseModel = petService.deletePet(3);
  }

  @Test
  public void checkThatDogWasDeletedTest() {

    int id = 5;
    PetModel pet = petService.getPetById(id);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(pet.getName())
        .as("Dog name should be [doggie]")
        .isEqualTo("doggie");

    //delete dog
    PetNotificationResponseModel deleteResponseModel = petService.deletePet(id);
    softly.assertThat(deleteResponseModel.getCode())
        .as("Code should be 200 in body")
        .isEqualTo(200);

    //get dog again
    petService.getNotExistedPet(id);
    softly.assertAll();
  }

  @Test
  public void createCat() {

//    PetModel petModel = new PetModel();
//    Category category = new Category();
//    category.setId(3);
//    category.setName("Cats");
//    petModel.setCategory(category);
//    petModel.setName("Kit");
//    List<String> photos = new ArrayList<>();
//    photos.add("https://my.cat.com");
//    petModel.setPhotoUrls(photos);
//    List<Tag> tags = new ArrayList<>();
//    Tag tag = new Tag();
//    tag.setId(32);
//    tag.setName("Best carts");
//    tags.add(tag);
//    petModel.setTags(tags);
//    petModel.setStatus("available");

    Category category = new Category(3, "Cats");
    List<String> photos = new ArrayList<>();
    photos.add("https://my.cat.com");
    List<Tag> tags = new ArrayList<>();
    Tag tag = new Tag(32, "Best carts");
    tags.add(tag);

    PetModel petModel = new PetModel(null, null, "Kit", photos, null, null);

    PetModel kit = PetModel.builder()
        .name("Kit")
        .photoUrls(photos)
        .status("sf")
        .build();


  }


}
