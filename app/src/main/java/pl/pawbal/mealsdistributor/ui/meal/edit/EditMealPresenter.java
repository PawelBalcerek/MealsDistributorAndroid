package pl.pawbal.mealsdistributor.ui.meal.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;

import java.time.DateTimeException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.MealBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.factory.EditMealFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.ui.action.error.MealErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.MealSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class EditMealPresenter<V extends EditMealMvpView> extends BasePresenter<V> implements EditMealMvpPresenter<V> {
    private final MealBundleFactory mealBundleFactory;
    private final EditMealFactory editMealFactory;
    private final MealSuccessHandler successHandler;
    private final MealErrorHandler errorHandler;
    private final MealService mealService;

    @Inject
    public EditMealPresenter(CompositeDisposable compositeDisposable,
                             MealBundleFactory mealBundleFactory,
                             EditMealFactory editMealFactory,
                             MealSuccessHandler successHandler,
                             MealErrorHandler errorHandler,
                             MealService mealService) {
        super(compositeDisposable);
        this.mealBundleFactory = mealBundleFactory;
        this.editMealFactory = editMealFactory;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
        this.mealService = mealService;
    }

    @Override
    public void bindMeal(Bundle bundle) {
        GetMeal meal = mealBundleFactory.getMeal(bundle);
        getMvpView().bindMeal(meal);
    }

    @Override
    public void saveMeal(String id, String name, String description, String price,
                         @Nullable Long startDate, @Nullable Long endDate) {
        getMvpView().showLoading();
        trySaveMeal(id, name, description, price, startDate, endDate);
    }

    private void trySaveMeal(String id, String name, String description, String price,
                             @Nullable Long startDate, @Nullable Long endDate) {
        try {
            EditMeal body = editMealFactory.create(id, name, description, price, startDate, endDate);
            mealService.editMeal(body, new CustomCompletableObserver(
                    getCompositeDisposable(),
                    () -> successHandler.onEditMealSuccess(getMvpView()),
                    t -> errorHandler.onEditMealError(t, getMvpView())
            ));
        } catch (NumberFormatException | DateTimeException e) {
            errorHandler.onEditMealError(e, getMvpView());
        }
    }
}
