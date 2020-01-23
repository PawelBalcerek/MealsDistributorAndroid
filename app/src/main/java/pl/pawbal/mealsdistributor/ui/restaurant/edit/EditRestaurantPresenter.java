package pl.pawbal.mealsdistributor.ui.restaurant.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.factory.RestaurantFactory;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class EditRestaurantPresenter<V extends EditRestaurantMvpView> extends BasePresenter<V> implements EditRestaurantMvpPresenter<V> {
    private final RestaurantBundleFactory restaurantBundleFactory;
    private final RestaurantFactory restaurantFactory;
    private final RestaurantService restaurantService;
    private final RestaurantSuccessHandler successHandler;
    private final RestaurantErrorHandler errorHandler;

    @Inject
    public EditRestaurantPresenter(CompositeDisposable compositeDisposable,
                                   RestaurantBundleFactory restaurantBundleFactory,
                                   RestaurantFactory restaurantFactory,
                                   RestaurantService restaurantService,
                                   RestaurantSuccessHandler successHandler,
                                   RestaurantErrorHandler errorHandler) {
        super(compositeDisposable);
        this.restaurantBundleFactory = restaurantBundleFactory;
        this.restaurantFactory = restaurantFactory;
        this.restaurantService = restaurantService;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void bindRestaurant(Bundle bundle) {
        Restaurant restaurant = restaurantBundleFactory.restaurant(bundle);
        getMvpView().bindRestaurant(restaurant);
    }

    @Override
    public void editRestaurant(String id, String name, String phoneNumber, @Nullable String minOrderCost,
                               @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                               boolean isPyszne) {
        getMvpView().showLoading();
        EditRestaurant body = restaurantFactory.create(id, name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);
        restaurantService.editRestaurant(body, new CustomCompletableObserver(
                getCompositeDisposable(),
                () -> successHandler.onEditRestaurantSuccess(getMvpView()),
                t -> errorHandler.onEditRestaurantError(t, getMvpView())
        ));
    }
}
