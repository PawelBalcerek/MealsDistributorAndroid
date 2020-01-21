package pl.pawbal.mealsdistributor.data.api.service.rest;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestaurantRestService {
    String RESTAURANT_BASE_PATH = "restaurant";
    String RESTAURANTS_BASE_PATH = "restaurants";

    @GET(RESTAURANT_BASE_PATH + "/{id}")
    Single<GetRestaurant> getRestaurant(@Path("id") UUID id);

    @GET(RESTAURANTS_BASE_PATH)
    Single<GetRestaurants> getRestaurants();

    @POST(RESTAURANT_BASE_PATH)
    Completable addRestaurant(@Body AddRestaurant addRestaurant);

    @PUT(RESTAURANT_BASE_PATH)
    Completable editRestaurant(@Body EditRestaurant editRestaurant);

    @DELETE(RESTAURANT_BASE_PATH + "/{id}")
    Completable deleteRestaurant(@Path("id") UUID id);
}
