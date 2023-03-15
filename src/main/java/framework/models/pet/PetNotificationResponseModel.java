package framework.models.pet;

import lombok.Data;

@Data
public class PetNotificationResponseModel {

    private Integer code;
    private String type;
    private String message;

}
