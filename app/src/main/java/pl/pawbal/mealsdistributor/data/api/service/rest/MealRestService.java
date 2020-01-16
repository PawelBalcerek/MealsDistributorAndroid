package pl.pawbal.mealsdistributor.data.api.service.rest;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MealRestService extends RestService {
    String MEAL_BASE_PATH = "/meal";
    String MEALS_BASE_PATH = "/meals";

    @GET(MEAL_BASE_PATH + "/{id}")
    Single<GetMeal> getMeal(@Path("id") UUID id);

    @GET("/restaurant/{restaurantId}" + MEALS_BASE_PATH)
    Single<GetMeals> getMeals(@Path("restaurantId") UUID restaurantId);

    @POST(MEAL_BASE_PATH)
    Single<Void> addMeal(@Body AddMeal body);

    @PUT(MEAL_BASE_PATH)
    Single<Void> editMeal(@Body EditMeal body);

    @DELETE(MEAL_BASE_PATH + "/{id}")
    Single<Void> deleteMeal(@Path("id") UUID id);
}