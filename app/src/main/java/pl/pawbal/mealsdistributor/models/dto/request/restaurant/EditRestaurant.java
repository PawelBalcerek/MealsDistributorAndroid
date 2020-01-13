package pl.pawbal.mealsdistributor.models.dto.request.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditRestaurant extends AddRestaurant {
    @Expose
    @SerializedName("id")
    private UUID id;
}
