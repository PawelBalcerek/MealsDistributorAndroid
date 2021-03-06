package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;

@Singleton
public class OrderWrapperService implements OrderService {
    private final OrderRestService orderRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    OrderWrapperService(OrderRestService orderRestService,
                        ResponseWrapper responseWrapper) {
        this.orderRestService = orderRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getOrder(UUID id, CustomSingleObserver<GetOrder> observer) {
        responseWrapper.wrapSingle(orderRestService.getOrder(id))
                .subscribe(observer);
    }

    @Override
    public void getOrders(CustomSingleObserver<GetOrders> observer) {
        responseWrapper.wrapSingle(orderRestService.getOrders())
                .subscribe(observer);
    }

    @Override
    public void markOrdered(UUID id, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(orderRestService.markOrdered(id))
                .subscribe(observer);
    }
}
