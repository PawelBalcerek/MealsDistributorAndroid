package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;

@Singleton
public class OrderWrapperService implements OrderService {
    private final OrderRestService orderRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    OrderWrapperService(OrderRestService orderRestService,
                        SingleWrapper singleWrapper) {
        this.orderRestService = orderRestService;
        this.singleWrapper = singleWrapper;
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
