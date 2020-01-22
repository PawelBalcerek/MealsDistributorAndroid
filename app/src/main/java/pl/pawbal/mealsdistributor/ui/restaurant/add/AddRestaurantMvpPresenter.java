package pl.pawbal.mealsdistributor.ui.restaurant.add;

import androidx.annotation.Nullable;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface AddRestaurantMvpPresenter<V> extends MvpPresenter<V> {
    void addRestaurant(String name, String phoneNumber, @Nullable String minOrderCost,
                       @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                       boolean isPyszne);
}
