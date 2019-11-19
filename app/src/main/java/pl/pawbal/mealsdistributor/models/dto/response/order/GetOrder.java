package pl.pawbal.mealsdistributor.models.dto.response.order;

import java.util.UUID;

import lombok.Data;

@Data
public class GetOrder {
    private UUID id;
    private UUID orderBoy;
    private boolean isOrder;
}
