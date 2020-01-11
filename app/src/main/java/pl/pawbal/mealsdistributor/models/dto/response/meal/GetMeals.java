package pl.pawbal.mealsdistributor.models.dto.response.meal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetMeals {
    @Expose
    @SerializedName("meals")
    private List<GetMeal> meals = new ArrayList<>();
}
