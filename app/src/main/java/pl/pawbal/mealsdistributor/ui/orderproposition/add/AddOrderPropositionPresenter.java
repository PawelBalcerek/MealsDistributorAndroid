package pl.pawbal.mealsdistributor.ui.orderproposition.add;

import java.time.DateTimeException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.factory.AddOrderPropositionFactory;
import pl.pawbal.mealsdistributor.ui.action.error.OrderPropositionErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.error.RestaurantErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.OrderPropositionSuccessHandler;
import pl.pawbal.mealsdistributor.ui.action.success.RestaurantSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AddOrderPropositionPresenter<V extends AddOrderPropositionMvpView> extends BasePresenter<V> implements AddOrderPropositionMvpPresenter<V> {
    private final RestaurantService restaurantService;
    private final RestaurantSuccessHandler restaurantSuccessHandler;
    private final RestaurantErrorHandler restaurantErrorHandler;
    private final AddOrderPropositionFactory addOrderPropositionFactory;
    private final OrderPropositionService orderPropositionService;
    private final OrderPropositionSuccessHandler orderPropositionSuccessHandler;
    private final OrderPropositionErrorHandler orderPropositionErrorHandler;

    @Inject
    public AddOrderPropositionPresenter(CompositeDisposable compositeDisposable,
                                        RestaurantService restaurantService,
                                        RestaurantSuccessHandler restaurantSuccessHandler,
                                        RestaurantErrorHandler restaurantErrorHandler,
                                        AddOrderPropositionFactory addOrderPropositionFactory,
                                        OrderPropositionService orderPropositionService,
                                        OrderPropositionSuccessHandler orderPropositionSuccessHandler,
                                        OrderPropositionErrorHandler orderPropositionErrorHandler) {
        super(compositeDisposable);
        this.restaurantService = restaurantService;
        this.restaurantSuccessHandler = restaurantSuccessHandler;
        this.restaurantErrorHandler = restaurantErrorHandler;
        this.addOrderPropositionFactory = addOrderPropositionFactory;
        this.orderPropositionService = orderPropositionService;
        this.orderPropositionSuccessHandler = orderPropositionSuccessHandler;
        this.orderPropositionErrorHandler = orderPropositionErrorHandler;
    }

    @Override
    public void getRestaurants() {
        getMvpView().showLoading();
        restaurantService.getRestaurants(new CustomSingleObserver<>(
                getCompositeDisposable(),
                r -> restaurantSuccessHandler.onGetRestaurantsSuccess(r, getMvpView()),
                t -> restaurantErrorHandler.onGetRestaurantError(t, getMvpView())
        ));
    }

    @Override
    public void addOrderProposition(String restaurantId, Long orderTime) {
        getMvpView().showLoading();
        tryAddOrderProposition(restaurantId, orderTime);
    }

    private void tryAddOrderProposition(String restaurantId, Long orderTime) {
        try {
            AddOrderProposition body = addOrderPropositionFactory.create(restaurantId, orderTime);
            orderPropositionService.addOrderProposition(body, new CustomCompletableObserver(
                    getCompositeDisposable(),
                    () -> orderPropositionSuccessHandler.onAddOrderPropositionSuccess(getMvpView()),
                    t -> orderPropositionErrorHandler.onAddOrderPropositionError(t, getMvpView())
            ));
        } catch (DateTimeException e) {
            orderPropositionErrorHandler.onAddOrderPropositionError(e, getMvpView());
        }
    }
}
