package pl.pawbal.mealsdistributor.models.dto.request.orderposition;

import java.util.UUID;

import lombok.Data;

@Data
public class AddOrderPosition {
    private UUID mealId;
}
