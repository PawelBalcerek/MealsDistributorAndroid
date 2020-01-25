package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface RestaurantDetailsMvpPresenter<V> extends MvpPresenter<V> {
    void getRestaurant(Bundle bundle);

    void deleteRestaurant(String restaurantId);

    void navigateToEditRestaurant(Restaurant restaurant);

    void navigateToMeals(String restaurantId);
}
