package pl.pawbal.mealsdistributor.data.api.service.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderposition.GetOrderPositions;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OrderPositionRestService {
    String ORDER_POSITIONS_BASE_PATH = "order-positions";

    @GET(ORDER_POSITIONS_BASE_PATH)
    Single<GetOrderPositions> getOrderPositions();

    @GET("/order/{orderId}" + ORDER_POSITIONS_BASE_PATH)
    Single<GetOrderPositions> getOrderPositions(@Path("orderId") UUID id);
}
