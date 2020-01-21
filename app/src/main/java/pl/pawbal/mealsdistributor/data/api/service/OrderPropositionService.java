package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;

public interface OrderPropositionService {
    void getParticipatedOrderPropositions(CustomSingleObserver<GetParticipatedOrderPropositions> observer);

    void getAvailableOrderPropositions(CustomSingleObserver<GetAvailableOrderPropositions> observer);

    void getOrderProposition(UUID id, CustomSingleObserver<GetOrderProposition> observer);

    void addOrderProposition(AddOrderProposition body, CustomCompletableObserver observer);

    void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer);
}
