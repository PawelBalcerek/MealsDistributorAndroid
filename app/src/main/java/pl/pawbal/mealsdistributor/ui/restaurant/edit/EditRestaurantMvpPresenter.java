package pl.pawbal.mealsdistributor.ui.restaurant.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface EditRestaurantMvpPresenter<V> extends MvpPresenter<V> {
    void bindRestaurant(Bundle bundle);

    void editRestaurant(String id, String name, String phoneNumber, @Nullable String minOrderCost,
                        @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                        boolean isPyszne);
}
