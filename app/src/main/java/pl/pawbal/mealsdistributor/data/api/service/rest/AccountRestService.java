package pl.pawbal.mealsdistributor.data.api.service.rest;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountRestService {
    String ACCOUNT_BASE_PATH = "account";

    @POST(ACCOUNT_BASE_PATH + "/login")
    Single<Response<Void>> login(@Body Login body);

    @GET(ACCOUNT_BASE_PATH + "/logout")
    Single<Void> logout();
}
