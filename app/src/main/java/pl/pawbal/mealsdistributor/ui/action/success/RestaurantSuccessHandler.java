package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.orderproposition.add.AddOrderPropositionMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpView;

public class RestaurantSuccessHandler {
    @Inject
    public RestaurantSuccessHandler() {
    }

    public void onGetRestaurantsSuccess(GetRestaurants restaurants, RestaurantMvpView view) {
        view.bindRestaurantsToList(restaurants.getRestaurants());
        view.hideLoading();
    }

    public void onGetRestaurantsSuccess(GetRestaurants restaurants, AddOrderPropositionMvpView view) {
        view.bindRestaurants(restaurants.getRestaurants());
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
