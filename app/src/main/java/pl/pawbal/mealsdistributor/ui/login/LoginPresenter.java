package pl.pawbal.mealsdistributor.ui.login;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.AccountFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {
    private final AccountService accountService;
    private final AccountFactory accountFactory;

    @Inject
    public LoginPresenter(CompositeDisposable compositeDisposable,
                          AccountService accountService,
                          AccountFactory accountFactory) {
        super(compositeDisposable);
        this.accountService = accountService;
        this.accountFactory = accountFactory;
    }

    @Override
    public void loginClick(String email, String password) {
        Login body = accountFactory.create(email, password);
        accountService.login(body, new CustomSingleObserver<>(
                getCompositeDisposable(),
                a -> Log.i("TEST", a.headers().toString()),
                t -> Log.i("TEST", "TEST", t))
        );
    }
}
