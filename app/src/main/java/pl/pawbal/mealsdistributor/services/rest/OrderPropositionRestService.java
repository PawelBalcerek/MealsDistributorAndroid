package pl.pawbal.mealsdistributor.services.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.response.order.GetOrder;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderPropositionRestService {
    String ORDER_PROPOSITION_BASE_PATH = "/order-proposition";
    String ORDER_PROPOSITIONS_BASE_PATH = "/order-propositions";

    @GET(ORDER_PROPOSITIONS_BASE_PATH + "/participated")
    Single<Void> getParticipatedOrderPropositions();

    @GET(ORDER_PROPOSITIONS_BASE_PATH + "/available")
    Single<Void> getAvailableOrderPropositions();

    @GET(ORDER_PROPOSITION_BASE_PATH + "/{id}")
    Single<Void> getOrderProposition(@Path("id") UUID id);

    @POST(ORDER_PROPOSITION_BASE_PATH)
    Single<Void> addOrderProposition(@Body Void body);

    @POST(ORDER_PROPOSITION_BASE_PATH + "/{id}/realize")
    Single<GetOrder> realizeOrderProposition(@Path("id") UUID id);
}
