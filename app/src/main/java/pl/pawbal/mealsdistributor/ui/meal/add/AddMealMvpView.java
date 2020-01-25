package pl.pawbal.mealsdistributor.ui.meal.add;

import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface AddMealMvpView extends MvpView {
    void bindRestaurantId(String restaurantId);

    void goBack();
}
