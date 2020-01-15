package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;

public interface OrderPropositionService {
    void getParticipatedOrderPropositions(CustomSingleObserver<GetParticipatedOrderPropositions> observer);

    void getAvailableOrderPropositions(CustomSingleObserver<GetAvailableOrderPropositions> observer);

    void getOrderProposition(UUID id, CustomSingleObserver<GetOrderProposition> observer);

    void addOrderProposition(AddOrderProposition body, CustomSingleObserver<Void> observer);

    void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer);
}
