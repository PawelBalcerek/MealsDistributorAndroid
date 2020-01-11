package pl.pawbal.mealsdistributor.models.dto.response.order;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class GetOrder {
    private UUID id;
    private UUID orderBoyId;
    private boolean isOrdered;
    private LocalDateTime creationDate;
}
