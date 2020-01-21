package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderPositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderposition.GetOrderPositions;

@Singleton
public class OrderPositionWrapperService implements OrderPositionService {
    private final OrderPositionRestService orderPositionRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    OrderPositionWrapperService(OrderPositionRestService orderPositionRestService,
                                ResponseWrapper responseWrapper) {
        this.orderPositionRestService = orderPositionRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getOrderPositions(CustomSingleObserver<GetOrderPositions> observer) {
        responseWrapper.wrapSingle(orderPositionRestService.getOrderPositions())
                .subscribe(observer);
    }

    @Override
    public void getOrderPositions(UUID orderId, CustomSingleObserver<GetOrderPositions> observer) {
        responseWrapper.wrapSingle(orderPositionRestService.getOrderPositions(orderId))
                .subscribe(observer);
    }
}
