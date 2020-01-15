package pl.pawbal.mealsdistributor.data.models.dto.request.restaurant;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AddRestaurant {
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @Expose
    @SerializedName("isPyszne")
    private boolean isPyszne;
    @Nullable
    @Expose
    @SerializedName("minOrderCost")
    private BigDecimal minOrderCost;
    @Nullable
    @Expose
    @SerializedName("deliveryCost")
    private BigDecimal deliveryCost;
    @Nullable
    @Expose
    @SerializedName("maxPaidOrderValue")
    private BigDecimal maxPaidOrderValue;
}
