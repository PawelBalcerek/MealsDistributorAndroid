package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Meal {
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("price")
    private BigDecimal price;
    @Expose
    @SerializedName("startDate")
    private LocalDateTime startDate;
    @Expose
    @SerializedName("endDate")
    private LocalDateTime endDate;
    @Expose
    @SerializedName("restaurantId")
    private UUID restaurantId;
}
