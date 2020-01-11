package pl.pawbal.mealsdistributor.models.dto.response.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetRestaurants {
    @Expose
    @SerializedName("restaurants")
    private List<GetRestaurant> restaurants = new ArrayList<>();
}
