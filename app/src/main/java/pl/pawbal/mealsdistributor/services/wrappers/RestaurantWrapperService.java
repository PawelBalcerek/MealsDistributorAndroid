package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.services.RestaurantService;
import pl.pawbal.mealsdistributor.services.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

public class RestaurantWrapperService implements RestaurantService {
    private final RestaurantRestService restaurantRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    RestaurantWrapperService(RestaurantRestService restaurantRestService, SingleWrapper singleWrapper) {
        this.restaurantRestService = restaurantRestService;
        this.singleWrapper = singleWrapper;
    }

    public RestaurantWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(RestaurantRestService.class), new SingleWrapper());
    }

    @Override
    public void getRestaurant(UUID id, CustomSingleObserver<GetRestaurant> observer) {
        singleWrapper.wrapSingle(restaurantRestService.getRestaurant(id))
                .subscribe(observer);
    }

    @Override
    public void getRestaurants(CustomSingleObserver<GetRestaurants> observer) {
        singleWrapper.wrapSingle(restaurantRestService.getRestaurants())
                .subscribe(observer);
    }

    @Override
    public void addRestaurant(AddRestaurant body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(restaurantRestService.addRestaurant(body))
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditRestaurant body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(restaurantRestService.editRestaurant(body))
                .subscribe(observer);
    }

    @Override
    public void deleteRestaurant(UUID id, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(restaurantRestService.deleteRestaurant(id))
                .subscribe(observer);
    }
}