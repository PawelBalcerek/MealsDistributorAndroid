package pl.pawbal.mealsdistributor.data.models.dto.request.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditRestaurant extends AddRestaurant {
    @Expose
    @SerializedName("id")
    private String id;
}
