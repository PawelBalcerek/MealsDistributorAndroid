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

public class RestaurantWrapperService implements RestaurantService {
    private final RestaurantRestService restaurantRestService;

    @SuppressWarnings("WeakerAccess")
    RestaurantWrapperService(RestaurantRestService restaurantRestService) {
        this.restaurantRestService = restaurantRestService;
    }

    public RestaurantWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(RestaurantRestService.class));
    }

    @Override
    public void getRestaurant(UUID id, CustomSingleObserver<GetRestaurant> observer) {
        restaurantRestService.getRestaurant(id)
                .subscribe(observer);
    }

    @Override
    public void getRestaurants(CustomSingleObserver<GetRestaurants> observer) {
        restaurantRestService.getRestaurants()
                .subscribe(observer);
    }

    @Override
    public void addRestaurant(AddRestaurant body, CustomSingleObserver<Void> observer) {
        restaurantRestService.addRestaurant(body)
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditRestaurant body, CustomSingleObserver<Void> observer) {
        restaurantRestService.editRestaurant(body)
                .subscribe(observer);
    }

    @Override
    public void deleteRestaurant(UUID id, CustomSingleObserver<Void> observer) {
        restaurantRestService.deleteRestaurant(id)
                .subscribe(observer);
    }
}
