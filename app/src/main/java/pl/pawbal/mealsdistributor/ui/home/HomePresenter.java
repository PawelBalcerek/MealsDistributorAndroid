package pl.pawbal.mealsdistributor.ui.home;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {
    @Inject
    public HomePresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }
}
