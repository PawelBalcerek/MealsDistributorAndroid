package pl.pawbal.mealsdistributor.ui.restaurant;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface RestaurantMvpPresenter<V> extends MvpPresenter<V> {
    void getRestaurants();
}
