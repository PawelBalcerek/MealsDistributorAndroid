package pl.pawbal.mealsdistributor.data.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderProposition {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("creatorID")
    private String creatorId;
    @Expose
    @SerializedName("restaurantId")
    private String restaurantId;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
    @Expose
    @SerializedName("timeToOrdering")
    private LocalDateTime timeToOrder;
    @Expose
    @SerializedName("orderingStopped")
    private boolean isStopped;
}
