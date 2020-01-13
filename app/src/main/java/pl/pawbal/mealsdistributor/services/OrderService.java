package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrders;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface OrderService {
    void getOrder(UUID id, CustomSingleObserver<GetOrder> observer);

    void getOrders(CustomSingleObserver<GetOrders> observer);

    void markOrdered(UUID id, CustomSingleObserver<Void> observer);
}
