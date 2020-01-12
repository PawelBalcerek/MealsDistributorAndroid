package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface OrderPropositionService {
    void getParticipatedOrderPropositions(CustomSingleObserver<Void> observer);

    void getAvailableOrderPropositions(CustomSingleObserver<Void> observer);

    void getOrderProposition(UUID id, CustomSingleObserver<Void> observer);

    void addOrderProposition(Void body, CustomSingleObserver<Void> observer);

    void realizeOrderProposition(UUID id, CustomSingleObserver<GetOrder> observer);
}
