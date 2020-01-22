package pl.pawbal.mealsdistributor.ui.restaurant.add;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.RestaurantFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AddRestaurantPresenter<V extends AddRestaurantMvpView> extends BasePresenter<V> implements AddRestaurantMvpPresenter<V> {
    private final RestaurantService restaurantService;
    private final RestaurantFactory restaurantFactory;
    private final RestaurantSuccessHandler restaurantSuccessHandler;
    private final RestaurantErrorHandler restaurantErrorHandler;

    @Inject
    public AddRestaurantPresenter(CompositeDisposable compositeDisposable,
                                  RestaurantService restaurantService,
                                  RestaurantFactory restaurantFactory,
                                  RestaurantSuccessHandler restaurantSuccessHandler,
                                  RestaurantErrorHandler restaurantErrorHandler) {
        super(compositeDisposable);
        this.restaurantService = restaurantService;
        this.restaurantFactory = restaurantFactory;
        this.restaurantSuccessHandler = restaurantSuccessHandler;
        this.restaurantErrorHandler = restaurantErrorHandler;
    }

    @Override
    public void addRestaurant(String name, String phoneNumber, @Nullable String minOrderCost,
                              @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                              boolean isPyszne) {
        getMvpView().showLoading();
        AddRestaurant addRestaurant = restaurantFactory.create(name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);
        restaurantService.addRestaurant(addRestaurant, new CustomCompletableObserver(
                getCompositeDisposable(),
                () -> restaurantSuccessHandler.onAddRestaurantSuccess(getMvpView()),
                t -> restaurantErrorHandler.onAddRestaurantError(t, getMvpView())));
    }
}
