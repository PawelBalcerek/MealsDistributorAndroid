package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;
import pl.pawbal.mealsdistributor.ui.main.MainMvpView;

public class AccountSuccessHandler {
    @Inject
    public AccountSuccessHandler() {
    }

    public void onLoginSuccess(LoginMvpView view) {
        view.navigateToMainActivity();
        view.hideLoading();
    }

    public void onLogoutSuccess(MainMvpView view) {
        view.hideLoading();
        view.onLogout();
    }
}
