package pl.pawbal.mealsdistributor.ui.meal.edit;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface EditMealMvpView extends MvpView {
    void bindMeal(GetMeal meal);

    void goBack();
}
