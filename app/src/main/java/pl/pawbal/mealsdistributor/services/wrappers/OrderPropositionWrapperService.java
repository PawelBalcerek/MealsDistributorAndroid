package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.services.OrderPropositionService;
import pl.pawbal.mealsdistributor.services.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

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
    public void getParticipatedOrderPropositions(CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getParticipatedOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getAvailableOrderPropositions(CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getAvailableOrderPropositions())
                .subscribe(observer);
    }

    @Override
    public void getOrderProposition(UUID id, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.getOrderProposition(id))
                .subscribe(observer);
    }

    @Override
    public void addOrderProposition(Void body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.addOrderProposition(body))
                .subscribe(observer);
    }

    @Override
    public void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer) {
        singleWrapper.wrapSingle(orderPropositionRestService.realizeOrderProposition(id))
                .subscribe(observer);
    }
}
