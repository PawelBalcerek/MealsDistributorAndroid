package pl.pawbal.mealsdistributor.models.dto.response.meal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.Meal;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMeal extends Meal {
    @Expose
    @SerializedName("id")
    private UUID id;
}
