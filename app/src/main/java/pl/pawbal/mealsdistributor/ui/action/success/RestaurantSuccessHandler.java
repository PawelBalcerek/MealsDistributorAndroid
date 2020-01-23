package pl.pawbal.mealsdistributor.ui.action.success;

import android.os.Bundle;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;

public class RestaurantSuccessHandler {
    private final SuccessHandler successHandler;
    private final RestaurantBundleFactory restaurantBundleFactory;

    @Inject
    public RestaurantSuccessHandler(SuccessHandler successHandler,
                                    RestaurantBundleFactory restaurantBundleFactory) {
        this.successHandler = successHandler;
        this.restaurantBundleFactory = restaurantBundleFactory;
    }

    public void onGetRestaurantsSuccess(GetRestaurants restaurants, RestaurantMvpView view) {
        view.bindRestaurantsToList(restaurants.getRestaurants());
        view.hideLoading();
    }

    public void onAddRestaurantSuccess(AddRestaurantMvpView view) {
        view.hideLoading();
        view.goBack();
    }

    public void onGetRestaurantSuccess(GetRestaurant restaurant, RestaurantMvpView view) {
        view.hideLoading();
        Bundle getRestaurant = restaurantBundleFactory.create(restaurant);
        view.navigateToRestaurantDetails(getRestaurant);
    }

    public void onDeleteRestaurantSuccess(RestaurantDetailsMvpView view) {
        view.hideLoading();
        view.onRestaurantDelete();
    }
}
