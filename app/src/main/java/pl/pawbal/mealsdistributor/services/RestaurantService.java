package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface RestaurantService {
    void getRestaurant(UUID id, CustomSingleObserver<GetRestaurant> observer);

    void getRestaurants(CustomSingleObserver<GetRestaurants> observer);

    void addRestaurant(AddRestaurant body, CustomSingleObserver<Void> observer);

    void editRestaurant(EditRestaurant body, CustomSingleObserver<Void> observer);

    void deleteRestaurant(UUID id, CustomSingleObserver<Void> observer);
}
