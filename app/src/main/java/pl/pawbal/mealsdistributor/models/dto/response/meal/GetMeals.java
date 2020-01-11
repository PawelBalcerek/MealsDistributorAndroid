package pl.pawbal.mealsdistributor.models.dto.response.meal;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetMeals {
    private List<GetMeal> meals = new ArrayList<>();
}
