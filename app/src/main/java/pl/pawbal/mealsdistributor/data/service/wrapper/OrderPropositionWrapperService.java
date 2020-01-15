package pl.pawbal.mealsdistributor.data.service.wrapper;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;
import pl.pawbal.mealsdistributor.data.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.service.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.SingleWrapper;

public class OrderPropositionWrapperService implements OrderPropositionService {
    private final OrderPropositionRestService orderPropositionRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    OrderPropositionWrapperService(OrderPropositionRestService orderPropositionRestService,
                                   SingleWrapper singleWrapper) {
        this.orderPropositionRestService = orderPropositionRestService;
        this.singleWrapper = singleWrapper;
    }

    public OrderPropositionWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(OrderPropositionRestService.class), SingleWrapper.singleWrapper());
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
