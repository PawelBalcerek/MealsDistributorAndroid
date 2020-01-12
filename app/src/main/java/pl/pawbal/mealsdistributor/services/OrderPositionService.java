package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

//TODO: usage of DTOs
public interface OrderPositionService {
    void getOrderPositions(CustomSingleObserver<Void> observer);

    void getOrderPositions(UUID orderPropositionId, CustomSingleObserver<Void> observer);

    void addOrderPosition(UUID orderPropositionId, Void body, CustomSingleObserver<Void> observer);
}
