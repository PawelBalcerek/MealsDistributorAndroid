package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.response.orderposition.GetOrderPositions;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface OrderPositionService {
    void getOrderPositions(CustomSingleObserver<GetOrderPositions> observer);

    void getOrderPositions(UUID orderId, CustomSingleObserver<GetOrderPositions> observer);
}
