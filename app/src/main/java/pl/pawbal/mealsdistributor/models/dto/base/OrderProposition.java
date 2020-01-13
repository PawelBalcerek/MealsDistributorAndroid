package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class OrderProposition {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("creatorId")
    private UUID creatorId;
    @Expose
    @SerializedName("restaurantId")
    private UUID restaurantId;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
    @Expose
    @SerializedName("timeToOrder")
    private LocalDateTime timeToOrder;
    @Expose
    @SerializedName("isFinished")
    private boolean isFinished;
}
