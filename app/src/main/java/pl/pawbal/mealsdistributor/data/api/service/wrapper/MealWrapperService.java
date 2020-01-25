package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.rest.MealRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;

@Singleton
public class MealWrapperService implements MealService {
    private final MealRestService mealRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    MealWrapperService(MealRestService mealRestService, ResponseWrapper responseWrapper) {
        this.mealRestService = mealRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getMeal(String id, CustomSingleObserver<GetMeal> observer) {
        responseWrapper.wrapSingle(mealRestService.getMeal(id))
                .subscribe(observer);
    }

    @Override
    public void getMeals(String restaurantId, CustomSingleObserver<GetMeals> observer) {
        responseWrapper.wrapSingle(mealRestService.getMeals(restaurantId))
                .subscribe(observer);
    }

    @Override
    public void addMeal(AddMeal body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(mealRestService.addMeal(body))
                .subscribe(observer);
    }

    @Override
    public void editMeal(EditMeal body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(mealRestService.editMeal(body))
                .subscribe(observer);
    }

    @Override
    public void deleteMeal(UUID id, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(mealRestService.deleteMeal(id))
                .subscribe(observer);
    }
}
