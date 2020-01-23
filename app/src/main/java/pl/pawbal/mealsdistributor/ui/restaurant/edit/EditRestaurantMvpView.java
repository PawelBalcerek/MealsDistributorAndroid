package pl.pawbal.mealsdistributor.ui.restaurant.edit;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface EditRestaurantMvpView extends MvpView {
    void bindRestaurant(Restaurant restaurant);

    void goBack();
}
