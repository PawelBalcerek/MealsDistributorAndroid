package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface OrderPropositionPositionService {
    void getOrderPropositionPositions(UUID orderPropositionId, CustomSingleObserver<GetOrderPropositionPositions> observer);

    void addOrderPropositionPosition(UUID orderPropositionId, AddOrderPropositionPosition body, CustomSingleObserver<Void> observer);
}
