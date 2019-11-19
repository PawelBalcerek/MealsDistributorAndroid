package pl.pawbal.mealsdistributor.models.dto.response.orderposition;

import java.util.UUID;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;

@Data
public class GetOrderPosition {
    private UUID id;
    private GetUser user;
    private GetMeal meal;
}
