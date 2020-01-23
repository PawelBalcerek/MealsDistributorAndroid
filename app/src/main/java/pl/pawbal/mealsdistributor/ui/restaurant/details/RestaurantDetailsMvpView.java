package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface RestaurantDetailsMvpView extends MvpView {
    void bindRestaurantDetails(GetRestaurant restaurant);

    void onRestaurantDelete();

    void navigateToEditRestaurantFragment(Bundle restaurant);
}
