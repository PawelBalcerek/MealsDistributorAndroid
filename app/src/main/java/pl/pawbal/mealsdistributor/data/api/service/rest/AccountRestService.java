package pl.pawbal.mealsdistributor.data.api.service.rest;

import io.reactivex.Completable;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountRestService {
    String ACCOUNT_BASE_PATH = "account";

    @POST(ACCOUNT_BASE_PATH + "/login")
    Completable login(@Body Login body);

    @GET(ACCOUNT_BASE_PATH + "/logout")
    Completable logout();
}
