package pl.pawbal.mealsdistributor.data.models.dto.base;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Meal {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("price")
    private BigDecimal price;
    @Nullable
    @Expose
    @SerializedName("startDate")
    private LocalDateTime startDate;
    @Nullable
    @Expose
    @SerializedName("endDate")
    private LocalDateTime endDate;
}
