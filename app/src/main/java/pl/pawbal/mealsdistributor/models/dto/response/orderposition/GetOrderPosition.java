package pl.pawbal.mealsdistributor.models.dto.response.orderposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;

@Data
public class GetOrderPosition {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("user")
    private GetUser user;
    @Expose
    @SerializedName("meal")
    private GetMeal meal;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
}
