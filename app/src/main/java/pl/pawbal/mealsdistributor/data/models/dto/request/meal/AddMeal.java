package pl.pawbal.mealsdistributor.data.models.dto.request.meal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AddMeal {
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
    private String restaurantId;
}
