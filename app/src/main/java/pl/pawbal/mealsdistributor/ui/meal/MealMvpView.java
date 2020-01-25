package pl.pawbal.mealsdistributor.ui.meal;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface MealMvpView extends MvpView {
    void bindToMealList(GetMeals meals);

    void navigateToMealDetailsFragment(Bundle bundle);
}
