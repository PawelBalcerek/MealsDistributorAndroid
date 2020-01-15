package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;

public interface OrderService {
    void getOrder(UUID id, CustomSingleObserver<GetOrder> observer);

    void getOrders(CustomSingleObserver<GetOrders> observer);

    void markOrdered(UUID id, CustomSingleObserver<Void> observer);
}
