package pl.pawbal.mealsdistributor.ui.meal.add;

import android.os.Bundle;

import androidx.annotation.Nullable;

import java.time.DateTimeException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.factory.AddMealFactory;
import pl.pawbal.mealsdistributor.ui.action.error.MealErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.MealSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AddMealPresenter<V extends AddMealMvpView> extends BasePresenter<V> implements AddMealMvpPresenter<V> {
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final AddMealFactory addMealFactory;
    private final MealSuccessHandler successHandler;
    private final MealErrorHandler errorHandler;
    private final MealService mealService;

    @Inject
    public AddMealPresenter(CompositeDisposable compositeDisposable,
                            RestaurantBundleFactory restaurantBundleFactory,
                            AddMealFactory addMealFactory,
                            MealSuccessHandler successHandler,
                            MealErrorHandler errorHandler,
                            MealService mealService) {
        super(compositeDisposable);
        this.restaurantBundleFactory = restaurantBundleFactory;
        this.addMealFactory = addMealFactory;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
        this.mealService = mealService;
    }

    @Override
    public void bindRestaurantId(Bundle bundle) {
        String restaurantId = restaurantBundleFactory.getRestaurantId(bundle);
        getMvpView().bindRestaurantId(restaurantId);
    }

    @Override
    public void addMeal(String name, String description, String price,
                        String restaurantId, @Nullable Long startDate, @Nullable Long endDate) {
        getMvpView().showLoading();
        tryAddMeal(name, description, price, restaurantId, startDate, endDate);
    }


    private void tryAddMeal(String name, String description, String price,
                            String restaurantId, @Nullable Long startDate, @Nullable Long endDate) {
        try {
            AddMeal meal = addMealFactory.create(name, description, price, restaurantId, startDate, endDate);
            mealService.addMeal(meal, new CustomCompletableObserver(
                    getCompositeDisposable(),
                    () -> successHandler.onAddMealSuccess(getMvpView()),
                    t -> errorHandler.onAddMealError(t, getMvpView())
            ));
        } catch (NumberFormatException | DateTimeException e) {
            errorHandler.onAddMealError(e, getMvpView());
        }
    }
}
