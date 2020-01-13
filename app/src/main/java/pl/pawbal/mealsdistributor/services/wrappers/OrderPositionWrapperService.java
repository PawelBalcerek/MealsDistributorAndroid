package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.orderposition.GetOrderPositions;
import pl.pawbal.mealsdistributor.services.OrderPositionService;
import pl.pawbal.mealsdistributor.services.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

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
