package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;

public interface OrderPropositionPositionService {
    void getOrderPropositionPositions(UUID orderPropositionId, CustomSingleObserver<GetOrderPropositionPositions> observer);

    void addOrderPropositionPosition(UUID orderPropositionId, AddOrderPropositionPosition body, CustomSingleObserver<Void> observer);
}
