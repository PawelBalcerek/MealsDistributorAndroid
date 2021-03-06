package pl.pawbal.mealsdistributor.ui.restaurant;

import android.os.Bundle;

import java.util.List;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface RestaurantMvpView extends MvpView {
    void bindRestaurantsToList(List<Restaurant> restaurants);

    void navigateToRestaurantDetails(Bundle bundle);
}
