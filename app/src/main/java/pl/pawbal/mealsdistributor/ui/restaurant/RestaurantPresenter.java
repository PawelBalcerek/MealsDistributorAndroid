package pl.pawbal.mealsdistributor.ui.restaurant;

import android.os.Bundle;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class RestaurantPresenter<V extends RestaurantMvpView> extends BasePresenter<V> implements RestaurantMvpPresenter<V> {
    private final RestaurantService restaurantService;
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final RestaurantSuccessHandler successHandler;
    private final RestaurantErrorHandler errorHandler;

    @Inject
    public RestaurantPresenter(CompositeDisposable compositeDisposable,
                               RestaurantService restaurantService,
                               RestaurantBundleFactory restaurantBundleFactory,
                               RestaurantSuccessHandler successHandler,
                               RestaurantErrorHandler errorHandler) {
        super(compositeDisposable);
        this.restaurantService = restaurantService;
        this.restaurantBundleFactory = restaurantBundleFactory;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void getRestaurants() {
        getMvpView().showLoading();
        restaurantService.getRestaurants(new CustomSingleObserver<>(
                getCompositeDisposable(),
                restaurants -> successHandler.onGetRestaurantsSuccess(restaurants, getMvpView()),
                t -> errorHandler.onGetRestaurantsError(t, getMvpView())));
    }

    @Override
    public void navigateToRestaurantDetails(String restaurantId) {
        Bundle bundle = restaurantBundleFactory.create(restaurantId);
        getMvpView().navigateToRestaurantDetails(bundle);
    }
}
