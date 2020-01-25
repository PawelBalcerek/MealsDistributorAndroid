package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;

public interface MealService {
    void getMeal(UUID id, CustomSingleObserver<GetMeal> observer);

    void getMeals(String restaurantId, CustomSingleObserver<GetMeals> observer);

    void addMeal(AddMeal body, CustomCompletableObserver observer);

    void editMeal(EditMeal body, CustomCompletableObserver observer);

    void deleteMeal(UUID id, CustomCompletableObserver observer);
}
