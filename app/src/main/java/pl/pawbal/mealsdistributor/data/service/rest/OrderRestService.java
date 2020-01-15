package pl.pawbal.mealsdistributor.data.service.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderRestService {
    String ORDERS_BASE_PATH = "/orders";
    String ORDER_BASE_PATH = "/order";

    @GET(ORDER_BASE_PATH + "/{id}")
    Single<GetOrder> getOrder(@Path("id") UUID id);

    @GET(ORDERS_BASE_PATH)
    Single<GetOrders> getOrders();

    @PUT(ORDER_BASE_PATH + "/{id}/ordered")
    Single<Void> markOrdered(@Path("id") UUID id);
}
