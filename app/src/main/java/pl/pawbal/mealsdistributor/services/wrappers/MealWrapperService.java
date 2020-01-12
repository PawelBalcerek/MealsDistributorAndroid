package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.services.MealService;
import pl.pawbal.mealsdistributor.services.rest.MealRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public class MealWrapperService implements MealService {
    private final MealRestService mealRestService;

    @SuppressWarnings("WeakerAccess")
    MealWrapperService(MealRestService mealRestService) {
        this.mealRestService = mealRestService;
    }

    public MealWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(MealRestService.class));
    }

    @Override
    public void getMeal(UUID id, CustomSingleObserver<GetMeal> observer) {
        mealRestService.getMeal(id)
                .subscribe(observer);
    }

    @Override
    public void getMeals(UUID restaurantId, CustomSingleObserver<GetMeals> observer) {
        mealRestService.getMeals(restaurantId)
                .subscribe(observer);
    }

    @Override
    public void addMeal(AddMeal body, CustomSingleObserver<Void> observer) {
        mealRestService.addMeal(body)
                .subscribe(observer);
    }

    @Override
    public void editMeal(EditMeal body, CustomSingleObserver<Void> observer) {
        mealRestService.editMeal(body)
                .subscribe(observer);
    }

    @Override
    public void deleteMeal(UUID id, CustomSingleObserver<Void> observer) {
        mealRestService.deleteMeal(id)
                .subscribe(observer);
    }
}
