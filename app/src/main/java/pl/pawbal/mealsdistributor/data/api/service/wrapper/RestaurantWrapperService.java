package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;

@Singleton
public class RestaurantWrapperService implements RestaurantService {
    private final RestaurantRestService restaurantRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    RestaurantWrapperService(RestaurantRestService restaurantRestService, ResponseWrapper responseWrapper) {
        this.restaurantRestService = restaurantRestService;
        this.responseWrapper = responseWrapper;
    }


    @Override
    public void getRestaurant(String id, CustomSingleObserver<GetRestaurant> observer) {
        responseWrapper.wrapSingle(restaurantRestService.getRestaurant(id))
                .subscribe(observer);
    }

    @Override
    public void getRestaurants(CustomSingleObserver<GetRestaurants> observer) {
        responseWrapper.wrapSingle(restaurantRestService.getRestaurants())
                .subscribe(observer);
    }

    @Override
    public void addRestaurant(AddRestaurant body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(restaurantRestService.addRestaurant(body))
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditRestaurant body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(restaurantRestService.editRestaurant(body))
                .subscribe(observer);
    }

    @Override
    public void deleteRestaurant(UUID id, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(restaurantRestService.deleteRestaurant(id))
                .subscribe(observer);
    }
}
