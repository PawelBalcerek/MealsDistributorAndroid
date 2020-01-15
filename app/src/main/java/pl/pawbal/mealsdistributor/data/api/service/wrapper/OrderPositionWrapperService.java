package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderposition.GetOrderPositions;
import pl.pawbal.mealsdistributor.data.api.service.OrderPositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;

public class OrderPositionWrapperService implements OrderPositionService {
    private final OrderPositionRestService orderPositionRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    OrderPositionWrapperService(OrderPositionRestService orderPositionRestService,
                                SingleWrapper singleWrapper) {
        this.orderPositionRestService = orderPositionRestService;
        this.singleWrapper = singleWrapper;
    }

    public OrderPositionWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(OrderPositionRestService.class), SingleWrapper.singleWrapper());
    }

    @Override
    public void getOrderPositions(CustomSingleObserver<GetOrderPositions> observer) {
        singleWrapper.wrapSingle(orderPositionRestService.getOrderPositions())
                .subscribe(observer);
    }

    @Override
    public void getOrderPositions(UUID orderId, CustomSingleObserver<GetOrderPositions> observer) {
        singleWrapper.wrapSingle(orderPositionRestService.getOrderPositions(orderId))
                .subscribe(observer);
    }
}
