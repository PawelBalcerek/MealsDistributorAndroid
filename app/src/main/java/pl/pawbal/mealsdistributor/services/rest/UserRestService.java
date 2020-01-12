package pl.pawbal.mealsdistributor.services.rest;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.LoginUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserRestService {
    String USER_BASE_PATH = "/api/user";

    @GET(USER_BASE_PATH)
    Single<GetUser> getCurrentUser();

    @POST(USER_BASE_PATH + "/register")
    Single<Void> registerUser(@Body RegisterUser user);

    @POST(USER_BASE_PATH + "/login")
    Single<Void> loginUser(@Body LoginUser user);

    @PUT(USER_BASE_PATH)
    Single<Void> editCurrentUser(@Body EditCurrentUser user);
}
