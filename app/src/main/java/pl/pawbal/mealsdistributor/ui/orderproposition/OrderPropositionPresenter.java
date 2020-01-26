package pl.pawbal.mealsdistributor.ui.orderproposition;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class OrderPropositionPresenter<V> extends BasePresenter<V> implements OrderPropositionMvpPresenter<V> {
    @Inject
    public OrderPropositionPresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }
}
