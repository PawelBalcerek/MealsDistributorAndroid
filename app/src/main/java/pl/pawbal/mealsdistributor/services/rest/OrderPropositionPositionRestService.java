package pl.pawbal.mealsdistributor.services.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderPropositionPositionRestService {
    String POSITION_BASE_PATH = "/position";
    String POSITIONS_BASE_PATH = "/positions";

    @GET("order-proposition/{orderPropositionId}" + POSITIONS_BASE_PATH)
    Single<GetOrderPropositionPositions> getOrderPropositionPositions(@Path("orderPropositionId") UUID orderPropositionId);

    @POST("order-propositions/{orderPropositionId}" + POSITION_BASE_PATH)
    Single<Void> addOrderPropositionPosition(@Path("orderPropositionId") UUID orderPropositionId,
                                             @Body AddOrderPropositionPosition body);
}
