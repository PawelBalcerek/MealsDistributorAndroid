package pl.pawbal.mealsdistributor.data.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;

public interface MealService {
    void getMeal(UUID id, CustomSingleObserver<GetMeal> observer);

    void getMeals(UUID restaurantId, CustomSingleObserver<GetMeals> observer);

    void addMeal(AddMeal body, CustomSingleObserver<Void> observer);

    void editMeal(EditMeal body, CustomSingleObserver<Void> observer);

    void deleteMeal(UUID id, CustomSingleObserver<Void> observer);
}
