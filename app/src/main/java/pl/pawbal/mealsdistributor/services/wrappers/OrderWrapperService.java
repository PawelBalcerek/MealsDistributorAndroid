package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrders;
import pl.pawbal.mealsdistributor.services.OrderService;
import pl.pawbal.mealsdistributor.services.rest.OrderRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

public class OrderWrapperService implements OrderService {
    private final OrderRestService orderRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    OrderWrapperService(OrderRestService orderRestService,
                        SingleWrapper singleWrapper) {
        this.orderRestService = orderRestService;
        this.singleWrapper = singleWrapper;
    }

    public OrderWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(OrderRestService.class), SingleWrapper.singleWrapper());
    }

    @Override
    public void getOrder(UUID id, CustomSingleObserver<GetOrder> observer) {
        singleWrapper.wrapSingle(orderRestService.getOrder(id))
                .subscribe(observer);
    }

    @Override
    public void getOrders(CustomSingleObserver<GetOrders> observer) {
        singleWrapper.wrapSingle(orderRestService.getOrders())
                .subscribe(observer);
    }

    @Override
    public void markOrdered(UUID id, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderRestService.markOrdered(id))
                .subscribe(observer);
    }
}
