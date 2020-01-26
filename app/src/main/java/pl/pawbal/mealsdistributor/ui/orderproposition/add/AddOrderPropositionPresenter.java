package pl.pawbal.mealsdistributor.ui.orderproposition.add;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class AddOrderPropositionPresenter<V extends AddOrderPropositionMvpView> extends BasePresenter<V> implements AddOrderPropositionMvpPresenter<V> {
    @Inject
    public AddOrderPropositionPresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }
}
