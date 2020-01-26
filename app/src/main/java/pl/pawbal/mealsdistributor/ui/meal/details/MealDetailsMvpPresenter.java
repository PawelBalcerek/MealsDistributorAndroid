package pl.pawbal.mealsdistributor.ui.meal.details;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface MealDetailsMvpPresenter<V> extends MvpPresenter<V> {
    void getMeal(Bundle bundle);

    void navigateToEditMealFragment(GetMeal meal);
}
