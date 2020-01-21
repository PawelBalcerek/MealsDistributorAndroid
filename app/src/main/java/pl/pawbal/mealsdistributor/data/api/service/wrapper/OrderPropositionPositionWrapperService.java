package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionPositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;

@Singleton
public class OrderPropositionPositionWrapperService implements OrderPropositionPositionService {
    private final OrderPropositionPositionRestService orderPropositionPositionRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    OrderPropositionPositionWrapperService(OrderPropositionPositionRestService orderPropositionPositionRestService, ResponseWrapper responseWrapper) {
        this.orderPropositionPositionRestService = orderPropositionPositionRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getOrderPropositionPositions(UUID orderPropositionId, CustomSingleObserver<GetOrderPropositionPositions> observer) {
        responseWrapper.wrapSingle(orderPropositionPositionRestService.getOrderPropositionPositions(orderPropositionId))
                .subscribe(observer);
    }

    @Override
    public void addOrderPropositionPosition(UUID orderPropositionId, AddOrderPropositionPosition body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(orderPropositionPositionRestService.addOrderPropositionPosition(orderPropositionId, body))
                .subscribe(observer);
    }
}
