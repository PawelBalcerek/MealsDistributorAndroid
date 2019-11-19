package pl.pawbal.mealsdistributor.models.dto.base;

import androidx.annotation.Nullable;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Restaurant {
    private String name;
    private String phoneNumber;
    private boolean isPyszne;
    @Nullable
    private BigDecimal minOrderCost;
    @Nullable
    private BigDecimal deliveryCost;
    @Nullable
    private BigDecimal maxPaidOrderValue;
}
