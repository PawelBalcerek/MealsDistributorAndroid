package pl.pawbal.mealsdistributor.models.dto.response.restaurant;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetRestaurants {
    private List<GetRestaurant> restaurants = new ArrayList<>();
}
