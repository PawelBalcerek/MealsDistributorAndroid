package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class OrderPosition {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("orderId")
    private UUID orderId;
    @Expose
    @SerializedName("user")
    private User user;
    @Expose
    @SerializedName("meal")
    private Meal meal;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
}
