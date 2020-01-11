package pl.pawbal.mealsdistributor.models.dto.request.meal;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.Meal;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditMeal extends Meal {
    private UUID id;
}
