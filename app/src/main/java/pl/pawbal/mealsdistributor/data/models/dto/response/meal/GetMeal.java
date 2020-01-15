package pl.pawbal.mealsdistributor.data.models.dto.response.meal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.data.models.dto.base.Meal;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMeal extends Meal {
}
