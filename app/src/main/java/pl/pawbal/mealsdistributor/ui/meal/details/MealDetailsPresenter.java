package pl.pawbal.mealsdistributor.ui.meal.details;

import android.os.Bundle;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.MealBundleFactory;
import pl.pawbal.mealsdistributor.ui.action.error.MealErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.MealSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class MealDetailsPresenter<V extends MealDetailsMvpView> extends BasePresenter<V> implements MealDetailsMvpPresenter<V> {
    private final MealBundleFactory mealBundleFactory;
    private final MealService mealService;
    private final MealSuccessHandler successHandler;
    private final MealErrorHandler errorHandler;

    @Inject
    public MealDetailsPresenter(CompositeDisposable compositeDisposable,
                                MealBundleFactory mealBundleFactory,
                                MealService mealService,
                                MealSuccessHandler successHandler,
                                MealErrorHandler errorHandler) {
        super(compositeDisposable);
        this.mealBundleFactory = mealBundleFactory;
        this.mealService = mealService;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void getMeal(Bundle bundle) {
        getMvpView().showLoading();
        String mealId = mealBundleFactory.getMealId(bundle);
        mealService.getMeal(mealId, new CustomSingleObserver<>(
                getCompositeDisposable(),
                m -> successHandler.onGetMealSuccess(m, getMvpView()),
                t -> errorHandler.onGetMealError(t, getMvpView())
        ));
    }
}
