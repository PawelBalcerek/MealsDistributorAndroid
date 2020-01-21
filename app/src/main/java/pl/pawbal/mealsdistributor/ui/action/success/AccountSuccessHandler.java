package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;

public class AccountSuccessHandler {
    @Inject
    public AccountSuccessHandler() {
    }

    public void onLoginSuccess(LoginMvpView view) {
        view.navigateToMainActivity();
    }
}
