package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;

@Singleton
public class OrderPropositionWrapperService implements OrderPropositionService {
    private final OrderPropositionRestService orderPropositionRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    OrderPropositionWrapperService(OrderPropositionRestService orderPropositionRestService,
                                   ResponseWrapper responseWrapper) {
        this.orderPropositionRestService = orderPropositionRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getParticipatedOrderPropositions(CustomSingleObserver<GetParticipatedOrderPropositions> observer) {
        responseWrapper.wrapSingle(orderPropositionRestService.getParticipatedOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getAvailableOrderPropositions(CustomSingleObserver<GetAvailableOrderPropositions> observer) {
        responseWrapper.wrapSingle(orderPropositionRestService.getAvailableOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getOrderProposition(UUID id, CustomSingleObserver<GetOrderProposition> observer) {
        responseWrapper.wrapSingle(orderPropositionRestService.getOrderProposition(id))
                .subscribe(observer);
    }

    @Override
    public void addOrderProposition(AddOrderProposition body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(orderPropositionRestService.addOrderProposition(body))
                .subscribe(observer);
    }

    @Override
    public void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer) {
        responseWrapper.wrapSingle(orderPropositionRestService.realizeOrderProposition(id))
                .subscribe(observer);
    }
}
