package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.rest.MealRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;

@Singleton
public class MealWrapperService implements MealService {
    private final MealRestService mealRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    MealWrapperService(MealRestService mealRestService, SingleWrapper singleWrapper) {
        this.mealRestService = mealRestService;
        this.singleWrapper = singleWrapper;
    }

    @Override
    public void getMeal(UUID id, CustomSingleObserver<GetMeal> observer) {
        singleWrapper.wrapSingle(mealRestService.getMeal(id))
                .subscribe(observer);
    }

    @Override
    public void getMeals(UUID restaurantId, CustomSingleObserver<GetMeals> observer) {
        singleWrapper.wrapSingle(mealRestService.getMeals(restaurantId))
                .subscribe(observer);
    }

    @Override
    public void addMeal(AddMeal body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(mealRestService.addMeal(body))
                .subscribe(observer);
    }

    @Override
    public void editMeal(EditMeal body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(mealRestService.editMeal(body))
                .subscribe(observer);
    }

    @Override
    public void deleteMeal(UUID id, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(mealRestService.deleteMeal(id))
                .subscribe(observer);
    }
}
