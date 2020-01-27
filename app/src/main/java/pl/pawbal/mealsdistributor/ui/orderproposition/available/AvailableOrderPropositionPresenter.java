package pl.pawbal.mealsdistributor.ui.orderproposition.available;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AvailableOrderPropositionPresenter<V extends AvailableOrderPropositionMvpView> extends BasePresenter<V> implements AvailableOrderPropositionMvpPresenter<V> {
    @Inject
    public AvailableOrderPropositionPresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }
}
