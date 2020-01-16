package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;

@Singleton
public class OrderPropositionWrapperService implements OrderPropositionService {
    private final OrderPropositionRestService orderPropositionRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    OrderPropositionWrapperService(OrderPropositionRestService orderPropositionRestService,
                                   SingleWrapper singleWrapper) {
        this.orderPropositionRestService = orderPropositionRestService;
        this.singleWrapper = singleWrapper;
    }

    @Override
    public void getParticipatedOrderPropositions(CustomSingleObserver<GetParticipatedOrderPropositions> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getParticipatedOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getAvailableOrderPropositions(CustomSingleObserver<GetAvailableOrderPropositions> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getAvailableOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getOrderProposition(UUID id, CustomSingleObserver<GetOrderProposition> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getOrderProposition(id))
                .subscribe(observer);
    }

    @Override
    public void addOrderProposition(AddOrderProposition body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.addOrderProposition(body))
                .subscribe(observer);
    }

    @Override
    public void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.realizeOrderProposition(id))
                .subscribe(observer);
    }
}
