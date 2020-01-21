package pl.pawbal.mealsdistributor.ui.login;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.AccountFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.ui.action.error.AccountErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.AccountSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {
    private final AccountService accountService;
    private final AccountFactory accountFactory;
    private final AccountSuccessHandler successHandler;
    private final AccountErrorHandler errorHandler;

    @Inject
    public LoginPresenter(CompositeDisposable compositeDisposable,
                          AccountService accountService,
                          AccountFactory accountFactory,
                          AccountSuccessHandler successHandler,
                          AccountErrorHandler errorHandler) {
        super(compositeDisposable);
        this.accountService = accountService;
        this.accountFactory = accountFactory;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void loginClick(String email, String password) {
        Login body = accountFactory.create(email, password);
        accountService.login(body, new CustomSingleObserver<>(
                getCompositeDisposable(),
                a -> successHandler.onLoginSuccess(getMvpView()),
                errorHandler::onLoginError
        ));
    }
}
