package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class RestaurantDetailsPresenter<V extends RestaurantDetailsMvpView> extends BasePresenter<V> implements RestaurantDetailsMvpPresenter<V> {
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final RestaurantService restaurantService;
    private final RestaurantSuccessHandler successHandler;
    private final RestaurantErrorHandler errorHandler;

    @Inject
    public RestaurantDetailsPresenter(CompositeDisposable compositeDisposable,
                                      RestaurantBundleFactory restaurantBundleFactory,
                                      RestaurantService restaurantService,
                                      RestaurantSuccessHandler restaurantSuccessHandler,
                                      RestaurantErrorHandler restaurantErrorHandler) {
        super(compositeDisposable);
        this.restaurantBundleFactory = restaurantBundleFactory;
        this.restaurantService = restaurantService;
        this.successHandler = restaurantSuccessHandler;
        this.errorHandler = restaurantErrorHandler;
    }

    @Override
    public void getRestaurant(@Nullable Bundle bundle) {
        String restaurantId = restaurantBundleFactory.getRestaurantId(bundle);
        getMvpView().showLoading();
        restaurantService.getRestaurant(restaurantId, new CustomSingleObserver<>(
                getCompositeDisposable(),
                restaurant -> successHandler.onGetRestaurantSuccess(restaurant, getMvpView()),
                t -> errorHandler.onGetRestaurantError(t, getMvpView())
        ));
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        getMvpView().showLoading();
        restaurantService.deleteRestaurant(restaurantId, new CustomCompletableObserver(
                getCompositeDisposable(),
                () -> successHandler.onDeleteRestaurantSuccess(getMvpView()),
                t -> errorHandler.onDeleteRestaurantError(t, getMvpView())));
    }

    @Override
    public void navigateToEditRestaurant(Restaurant restaurant) {
        Bundle bundle = restaurantBundleFactory.create(restaurant);
        getMvpView().navigateToEditRestaurantFragment(bundle);
    }

    @Override
    public void navigateToMeals(String restaurantId) {
        Bundle bundle = restaurantBundleFactory.create(restaurantId);
        getMvpView().navigateToMealFragment(bundle);
    }
}
