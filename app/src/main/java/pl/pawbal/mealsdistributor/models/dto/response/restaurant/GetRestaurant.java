package pl.pawbal.mealsdistributor.models.dto.response.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.Restaurant;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetRestaurant extends Restaurant {
    @Expose
    @SerializedName("id")
    private UUID id;
}
