package framework.models.pet;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PetModel {

  private Integer id;
  private Category category;
  private String name;
  private List<String> photoUrls;
  private List<Tag> tags;
  private String status;


  @Data
  @AllArgsConstructor
  public static class Category {

    private Integer id;
    private String name;
  }

  @Data
  @AllArgsConstructor
  public static class Tag {

    private Integer id;
    private String name;
  }

}
