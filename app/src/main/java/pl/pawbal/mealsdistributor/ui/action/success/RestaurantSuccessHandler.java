package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;

public class RestaurantSuccessHandler {
    private final SuccessHandler successHandler;

    @Inject
    public RestaurantSuccessHandler(SuccessHandler successHandler) {
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
}
