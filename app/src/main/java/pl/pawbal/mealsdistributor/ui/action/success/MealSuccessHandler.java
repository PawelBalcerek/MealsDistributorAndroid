package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.add.AddMealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.details.MealDetailsMvpView;

public class MealSuccessHandler {
    @Inject
    public MealSuccessHandler() {
    }

    public void onGetMealsSuccess(GetMeals meals, MealMvpView view) {
        view.hideLoading();
        view.bindToMealList(meals);
    }

    public void onAddMealSuccess(AddMealMvpView view) {
        view.hideLoading();
        view.goBack();
    }

    public void onGetMealSuccess(GetMeal meal, MealDetailsMvpView view) {
        view.hideLoading();
        view.bindMeal(meal);
    }
}
