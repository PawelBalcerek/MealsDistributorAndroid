package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class RestaurantDetailsPresenter<V extends RestaurantDetailsMvpView> extends BasePresenter<V> implements RestaurantDetailsMvpPresenter<V> {
    private final RestaurantBundleFactory restaurantBundleFactory;

    @Inject
    public RestaurantDetailsPresenter(CompositeDisposable compositeDisposable, RestaurantBundleFactory restaurantBundleFactory) {
        super(compositeDisposable);
        this.restaurantBundleFactory = restaurantBundleFactory;
    }

    @Override
    public void bindGetRestaurant(@Nullable Bundle bundle) {
        GetRestaurant getRestaurant = restaurantBundleFactory.getRestaurant(bundle);
        getMvpView().bindRestaurantDetails(getRestaurant);
    }
}
