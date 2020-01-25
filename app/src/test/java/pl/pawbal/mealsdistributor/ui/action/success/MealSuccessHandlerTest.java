package pl.pawbal.mealsdistributor.ui.action.success;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;

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

}