package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Order {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("orderBoyId")
    private UUID orderBoyId;
    @Expose
    @SerializedName("restaurantId")
    private UUID restaurantId;
    @Expose
    @SerializedName("isOrdered")
    private boolean isOrdered;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
}
