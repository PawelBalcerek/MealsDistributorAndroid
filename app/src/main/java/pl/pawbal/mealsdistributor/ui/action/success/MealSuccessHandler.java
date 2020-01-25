package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;

public class MealSuccessHandler {
    @Inject
    public MealSuccessHandler() {
    }

    public void onGetMealsSuccess(GetMeals meals, MealMvpView view) {
        view.hideLoading();
        view.bindToMealList(meals);
    }
}
