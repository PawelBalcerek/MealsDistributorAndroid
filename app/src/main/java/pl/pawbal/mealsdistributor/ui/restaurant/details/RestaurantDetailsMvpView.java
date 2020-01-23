package pl.pawbal.mealsdistributor.ui.restaurant.details;

import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface RestaurantDetailsMvpView extends MvpView {
    void bindRestaurantDetails(GetRestaurant restaurant);
}
