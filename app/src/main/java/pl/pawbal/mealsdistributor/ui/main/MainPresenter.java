package pl.pawbal.mealsdistributor.ui.main;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.ui.action.error.AccountErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.error.UserErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.AccountSuccessHandler;
import pl.pawbal.mealsdistributor.ui.action.success.UserSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    private final UserService userService;
    private final UserSuccessHandler userSuccessHandler;
    private final UserErrorHandler userErrorHandler;
    private final AccountService accountService;
    private final AccountSuccessHandler accountSuccessHandler;
    private final AccountErrorHandler accountErrorHandler;

    @Inject
    public MainPresenter(CompositeDisposable compositeDisposable,
                         UserService userService,
                         UserSuccessHandler userSuccessHandler,
                         UserErrorHandler userErrorHandler,
                         AccountService accountService,
                         AccountSuccessHandler accountSuccessHandler,
                         AccountErrorHandler accountErrorHandler) {
        super(compositeDisposable);
        this.userService = userService;
        this.userSuccessHandler = userSuccessHandler;
        this.userErrorHandler = userErrorHandler;
        this.accountService = accountService;
        this.accountSuccessHandler = accountSuccessHandler;
        this.accountErrorHandler = accountErrorHandler;
    }

    @Override
    public void onNavigateToHome() {
        getMvpView().closeMenu();
        getMvpView().navigateToHomeFragment();
    }

    @Override
    public void onNavigateToRestaurant() {
        getMvpView().closeMenu();
        getMvpView().navigateToRestaurantFragment();
    }

    @Override
    public void onNavigateToOrderProposition() {
        getMvpView().closeMenu();
        getMvpView().navigateToOrderPropositionFragment();
    }

    @Override
    public void getCurrentUser() {
        getMvpView().showLoading();
        userService.getCurrentUser(new CustomSingleObserver<>(
                getCompositeDisposable(),
                u -> userSuccessHandler.onGetCurrentUserSuccess(u, getMvpView()),
                t -> userErrorHandler.onGetCurrentUserError(t, getMvpView())
        ));
    }

    @Override
    public void logout() {
        getMvpView().showLoading();
        accountService.logout(new CustomCompletableObserver(
                getCompositeDisposable(),
                () -> accountSuccessHandler.onLogoutSuccess(getMvpView()),
                t -> accountErrorHandler.onLogoutError(t, getMvpView())
        ));
    }
}
