package pl.pawbal.mealsdistributor.data.api.service;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;

public interface RestaurantService {
    void getRestaurant(String id, CustomSingleObserver<GetRestaurant> observer);

    void getRestaurants(CustomSingleObserver<GetRestaurants> observer);

    void addRestaurant(AddRestaurant body, CustomCompletableObserver observer);

    void editRestaurant(EditRestaurant body, CustomCompletableObserver observer);

    void deleteRestaurant(String id, CustomCompletableObserver observer);
}
