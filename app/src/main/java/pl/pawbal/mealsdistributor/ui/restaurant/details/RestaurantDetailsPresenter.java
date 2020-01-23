package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class RestaurantDetailsPresenter<V extends RestaurantDetailsMvpView> extends BasePresenter<V> implements RestaurantDetailsMvpPresenter<V> {
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final RestaurantService restaurantWrapperService;
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
        this.restaurantWrapperService = restaurantService;
        this.successHandler = restaurantSuccessHandler;
        this.errorHandler = restaurantErrorHandler;
    }

    @Override
    public void bindGetRestaurant(@Nullable Bundle bundle) {
        GetRestaurant getRestaurant = restaurantBundleFactory.getRestaurant(bundle);
        getMvpView().bindRestaurantDetails(getRestaurant);
    }

    @Override
    public void deleteRestaurant(String id) {
        getMvpView().showLoading();
        restaurantWrapperService.deleteRestaurant(id, new CustomCompletableObserver(
                getCompositeDisposable(),
                () -> successHandler.onDeleteRestaurantSuccess(getMvpView()),
                t -> errorHandler.onDeleteRestaurantError(t, getMvpView())));
    }
}
