package pl.pawbal.mealsdistributor.data.models.dto.response.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;

@Data
public class GetRestaurant {
    @Expose
    @SerializedName("restaurant")
    private Restaurant restaurant;

    @Expose
    @SerializedName("meals")
    private List<GetMeal> meals;
}
