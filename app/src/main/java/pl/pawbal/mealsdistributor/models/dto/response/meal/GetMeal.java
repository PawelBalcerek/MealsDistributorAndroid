package pl.pawbal.mealsdistributor.models.dto.response.meal;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.Meal;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMeal extends Meal {
    private UUID id;
}
