package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpView;

public class RestaurantSuccessHandler {
    private final SuccessHandler successHandler;

    @Inject
    public RestaurantSuccessHandler(SuccessHandler successHandler,
                                    RestaurantBundleFactory restaurantBundleFactory) {
        this.successHandler = successHandler;
    }

    public void onGetRestaurantsSuccess(GetRestaurants restaurants, RestaurantMvpView view) {
        view.bindRestaurantsToList(restaurants.getRestaurants());
        view.hideLoading();
    }

    public void onAddRestaurantSuccess(AddRestaurantMvpView view) {
        view.hideLoading();
        view.goBack();
    }

    public void onGetRestaurantSuccess(GetRestaurant restaurant, RestaurantDetailsMvpView view) {
        view.hideLoading();
        view.bindRestaurantDetails(restaurant);
    }

    public void onDeleteRestaurantSuccess(RestaurantDetailsMvpView view) {
        view.hideLoading();
        view.onRestaurantDelete();
    }

    public void onEditRestaurantSuccess(EditRestaurantMvpView view) {
        view.hideLoading();
        view.goBack();
    }
}
