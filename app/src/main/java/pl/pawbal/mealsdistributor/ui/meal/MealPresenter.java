package pl.pawbal.mealsdistributor.ui.meal;

import android.os.Bundle;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.MealBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.ui.action.error.MealErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.MealSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class MealPresenter<V extends MealMvpView> extends BasePresenter<V> implements MealMvpPresenter<V> {
    private final MealService mealService;
    private final MealSuccessHandler successHandler;
    private final MealErrorHandler errorHandler;
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final MealBundleFactory mealBundleFactory;

    @Inject
    public MealPresenter(CompositeDisposable compositeDisposable,
                         MealService mealService,
                         MealSuccessHandler successHandler,
                         MealErrorHandler errorHandler,
                         RestaurantBundleFactory restaurantBundleFactory,
                         MealBundleFactory mealBundleFactory) {
        super(compositeDisposable);
        this.mealService = mealService;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
        this.restaurantBundleFactory = restaurantBundleFactory;
        this.mealBundleFactory = mealBundleFactory;
    }

    @Override
    public void getMeals(Bundle bundle) {
        getMvpView().showLoading();
        String restaurantId = restaurantBundleFactory.getRestaurantId(bundle);
        mealService.getMeals(restaurantId, new CustomSingleObserver<>(
                getCompositeDisposable(),
                m -> successHandler.onGetMealsSuccess(m, getMvpView()),
                t -> errorHandler.onGetMealsError(t, getMvpView())
        ));
    }

    @Override
    public void navigateToMealDetails(String mealId) {
        Bundle bundle = mealBundleFactory.create(mealId);
        getMvpView().navigateToMealDetailsFragment(bundle);
    }
}
