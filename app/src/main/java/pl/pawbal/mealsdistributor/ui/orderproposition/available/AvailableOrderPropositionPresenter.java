package pl.pawbal.mealsdistributor.ui.orderproposition.available;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.ui.action.error.OrderPropositionErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.OrderPropositionSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AvailableOrderPropositionPresenter<V extends AvailableOrderPropositionMvpView> extends BasePresenter<V> implements AvailableOrderPropositionMvpPresenter<V> {
    private final OrderPropositionService orderPropositionService;
    private final OrderPropositionSuccessHandler orderPropositionSuccessHandler;
    private final OrderPropositionErrorHandler orderPropositionErrorHandler;

    @Inject
    public AvailableOrderPropositionPresenter(CompositeDisposable compositeDisposable,
                                              OrderPropositionService orderPropositionService,
                                              OrderPropositionSuccessHandler orderPropositionSuccessHandler,
                                              OrderPropositionErrorHandler orderPropositionErrorHandler) {
        super(compositeDisposable);
        this.orderPropositionService = orderPropositionService;
        this.orderPropositionSuccessHandler = orderPropositionSuccessHandler;
        this.orderPropositionErrorHandler = orderPropositionErrorHandler;
    }

    @Override
    public void getAvailableOrderPropositions() {
        getMvpView().showLoading();
        orderPropositionService.getAvailableOrderPropositions(new CustomSingleObserver<>(
                getCompositeDisposable(),
                aop -> orderPropositionSuccessHandler.onGetAvailableOrderPropositionsSuccess(aop, getMvpView()),
                t -> orderPropositionErrorHandler.onGetAvailableOrderPropositionsError(t, getMvpView())
        ));
    }
}
