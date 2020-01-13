package pl.pawbal.mealsdistributor.models.dto.request.orderproposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AddOrderProposition {
    @Expose
    @SerializedName("restaurantId")
    private UUID restaurantId;
    @Expose
    @SerializedName("orderTime")
    private LocalDateTime orderTime;
}
