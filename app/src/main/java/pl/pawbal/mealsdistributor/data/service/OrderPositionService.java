package pl.pawbal.mealsdistributor.data.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.response.orderposition.GetOrderPositions;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;

public interface OrderPositionService {
    void getOrderPositions(CustomSingleObserver<GetOrderPositions> observer);

    void getOrderPositions(UUID orderId, CustomSingleObserver<GetOrderPositions> observer);
}
