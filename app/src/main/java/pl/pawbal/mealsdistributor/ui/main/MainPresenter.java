package pl.pawbal.mealsdistributor.ui.main;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }
}