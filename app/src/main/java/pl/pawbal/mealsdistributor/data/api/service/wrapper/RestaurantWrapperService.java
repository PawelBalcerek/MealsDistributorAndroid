package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;

@Singleton
public class RestaurantWrapperService implements RestaurantService {
    private final RestaurantRestService restaurantRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    RestaurantWrapperService(RestaurantRestService restaurantRestService, SingleWrapper singleWrapper) {
        this.restaurantRestService = restaurantRestService;
        this.singleWrapper = singleWrapper;
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