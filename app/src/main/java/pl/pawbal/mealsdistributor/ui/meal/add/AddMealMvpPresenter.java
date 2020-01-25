package pl.pawbal.mealsdistributor.ui.meal.add;

import android.os.Bundle;

import androidx.annotation.Nullable;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface AddMealMvpPresenter<V> extends MvpPresenter<V> {
    void bindRestaurantId(Bundle bundle);

    void addMeal(String name, String description, String price,
                 String restaurantId, @Nullable Long startDate, @Nullable Long endDate);
}
