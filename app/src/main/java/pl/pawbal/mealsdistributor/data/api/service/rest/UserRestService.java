package pl.pawbal.mealsdistributor.data.api.service.rest;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserRestService {
    String USER_BASE_PATH = "user";

    @GET(USER_BASE_PATH)
    Single<GetUser> getCurrentUser();

    @GET(USER_BASE_PATH + "/{id}")
    Single<GetUser> getUser(@Path("id") UUID id);

    @POST(USER_BASE_PATH)
    Completable registerUser(@Body RegisterUser user);

    @PUT(USER_BASE_PATH)
    Completable editCurrentUser(@Body EditCurrentUser user);
}
