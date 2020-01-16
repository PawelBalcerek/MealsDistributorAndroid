package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionPositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;

@Singleton
public class OrderPropositionPositionWrapperService implements OrderPropositionPositionService {
    private final OrderPropositionPositionRestService orderPropositionPositionRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    OrderPropositionPositionWrapperService(OrderPropositionPositionRestService orderPropositionPositionRestService, SingleWrapper singleWrapper) {
        this.orderPropositionPositionRestService = orderPropositionPositionRestService;
        this.singleWrapper = singleWrapper;
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
