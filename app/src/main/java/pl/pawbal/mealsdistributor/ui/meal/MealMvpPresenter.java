package pl.pawbal.mealsdistributor.ui.meal;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface MealMvpPresenter<V> extends MvpPresenter<V> {
    void getMeals(Bundle bundle);

    void navigateToMealDetails(String mealId);
}
