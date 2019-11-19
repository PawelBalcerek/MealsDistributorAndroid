package pl.pawbal.mealsdistributor.models.dto.base;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Restaurant {
    private String name;
    private String phoneNumber;
    private boolean isPyszne;
    private BigDecimal minOrderCost;
    private BigDecimal deliveryCost;
    private BigDecimal maxPaidOrderValue;
}
