package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;

public interface OrderService {
    void getOrder(UUID id, CustomSingleObserver<GetOrder> observer);

    void getOrders(CustomSingleObserver<GetOrders> observer);

    void markOrdered(UUID id, CustomCompletableObserver observer);
}
