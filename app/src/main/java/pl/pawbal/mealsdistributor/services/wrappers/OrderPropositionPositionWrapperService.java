package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;
import pl.pawbal.mealsdistributor.services.OrderPropositionPositionService;
import pl.pawbal.mealsdistributor.services.rest.OrderPropositionPositionRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

public class OrderPropositionPositionWrapperService implements OrderPropositionPositionService {
    private final OrderPropositionPositionRestService orderPropositionPositionRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    OrderPropositionPositionWrapperService(OrderPropositionPositionRestService orderPropositionPositionRestService, SingleWrapper singleWrapper) {
        this.orderPropositionPositionRestService = orderPropositionPositionRestService;
        this.singleWrapper = singleWrapper;
    }

    public OrderPropositionPositionWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(OrderPropositionPositionRestService.class), SingleWrapper.singleWrapper());
    }

    @Override
    public void getOrderPropositionPositions(UUID orderPropositionId, CustomSingleObserver<GetOrderPropositionPositions> observer) {
        singleWrapper.wrapSingle(orderPropositionPositionRestService.getOrderPropositionPositions(orderPropositionId))
                .subscribe(observer);
    }

    @Override
    public void addOrderPropositionPosition(UUID orderPropositionId, AddOrderPropositionPosition body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionPositionRestService.addOrderPropositionPosition(orderPropositionId, body))
                .subscribe(observer);
    }
}
