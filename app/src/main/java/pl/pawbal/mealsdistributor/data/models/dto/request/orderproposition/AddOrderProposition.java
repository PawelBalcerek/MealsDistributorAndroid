package pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AddOrderProposition {
    @Expose
    @SerializedName("restaurantId")
    private String restaurantId;
    @Expose
    @SerializedName("orderingTime")
    private LocalDateTime orderTime;
}
