package pl.pawbal.mealsdistributor.ui.meal.details;

import android.os.Bundle;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface MealDetailsMvpView extends MvpView {
    void bindMeal(GetMeal meal);

    void navigateToEditMealFragment(Bundle bundle);
}
