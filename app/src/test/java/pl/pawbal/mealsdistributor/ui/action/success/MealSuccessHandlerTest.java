package pl.pawbal.mealsdistributor.ui.action.success;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.add.AddMealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.details.MealDetailsMvpView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MealSuccessHandlerTest {
    private final MealSuccessHandler successHandler = new MealSuccessHandler();

    @Test
    void onGetMealsSuccess() {
        //given
        GetMeals meals = new GetMeals();
        MealMvpView view = Mockito.mock(MealMvpView.class);

        //when
        successHandler.onGetMealsSuccess(meals, view);

        //then
        verify(view).hideLoading();
        verify(view).bindToMealList(meals);
    }

    @Test
    void onAddMealSuccess() {
        //given
        AddMealMvpView view = mock(AddMealMvpView.class);

        //when
        successHandler.onAddMealSuccess(view);

        //then
        verify(view).hideLoading();
        verify(view).goBack();
    }

    @Test
    void onGetMealSuccess() {
        //given
        GetMeal meal = new GetMeal();
        MealDetailsMvpView view = Mockito.mock(MealDetailsMvpView.class);

        //when
        successHandler.onGetMealSuccess(meal, view);

        //then
        verify(view).hideLoading();
        verify(view).bindMeal(meal);
    }

}