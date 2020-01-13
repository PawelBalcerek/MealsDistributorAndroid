package pl.pawbal.mealsdistributor.services.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.models.dto.response.orderproposition.GetParticipatedOrderPropositions;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderPropositionRestService {
    String ORDER_PROPOSITION_BASE_PATH = "/order-proposition";
    String ORDER_PROPOSITIONS_BASE_PATH = "/order-propositions";

    @GET(ORDER_PROPOSITIONS_BASE_PATH + "/participated")
    Single<GetParticipatedOrderPropositions> getParticipatedOrderPropositions();

    @GET(ORDER_PROPOSITIONS_BASE_PATH + "/available")
    Single<GetAvailableOrderPropositions> getAvailableOrderPropositions();

    @GET(ORDER_PROPOSITION_BASE_PATH + "/{id}")
    Single<GetOrderProposition> getOrderProposition(@Path("id") UUID id);

    @POST(ORDER_PROPOSITION_BASE_PATH)
    Single<Void> addOrderProposition(@Body AddOrderProposition body);

    @POST(ORDER_PROPOSITION_BASE_PATH + "/{id}/realize")
    Single<GetOrder> realizeOrderProposition(@Path("id") UUID id);
}
