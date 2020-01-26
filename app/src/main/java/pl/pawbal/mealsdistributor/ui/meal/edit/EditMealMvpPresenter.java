package pl.pawbal.mealsdistributor.ui.meal.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface EditMealMvpPresenter<V> extends MvpPresenter<V> {
    void bindMeal(Bundle bundle);

    void saveMeal(String id, String name, String description, String price,
                  @Nullable Long startDate, @Nullable Long endDate);
}
