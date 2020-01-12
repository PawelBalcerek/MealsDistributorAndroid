package pl.pawbal.mealsdistributor.services.rest;

import java.util.UUID;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//TODO: usage of DTOs
public interface OrderPositionRestService {
    String ORDER_POSITIONS_BASE_PATH = "/order-positions";
    String POSITION_BASE_PATH = "/position";
    String POSITIONS_BASE_PATH = "/positions";

    @GET(ORDER_POSITIONS_BASE_PATH)
    Single<Void> getOrderPositions();

    @GET("order-proposition/{orderPropositionId}" + POSITIONS_BASE_PATH)
    Single<Void> getOrderPositions(@Path("orderPropositionId") UUID orderPropositionId);

    @POST("order-propositions/{orderPropositionId}" + POSITION_BASE_PATH)
    Single<Void> addOrderPosition(@Path("orderPropositionId") UUID orderPropositionId,
                                  @Body Void body);
}
