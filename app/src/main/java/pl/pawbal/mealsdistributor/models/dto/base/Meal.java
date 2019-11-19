package pl.pawbal.mealsdistributor.models.dto.base;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Meal {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UUID restaurantId;
}
