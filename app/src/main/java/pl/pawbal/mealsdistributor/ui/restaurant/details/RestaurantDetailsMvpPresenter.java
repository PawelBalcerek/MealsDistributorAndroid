package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import androidx.annotation.Nullable;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface RestaurantDetailsMvpPresenter<V> extends MvpPresenter<V> {
    void bindGetRestaurant(@Nullable Bundle bundle);
}
