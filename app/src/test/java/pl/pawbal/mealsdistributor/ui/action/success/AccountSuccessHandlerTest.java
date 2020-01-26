package pl.pawbal.mealsdistributor.ui.action.success;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;
import pl.pawbal.mealsdistributor.ui.main.MainMvpView;

import static org.mockito.Mockito.verify;

class AccountSuccessHandlerTest {
    private final AccountSuccessHandler accountSuccessHandler = new AccountSuccessHandler();

    @Test
    void onLoginSuccess() {
        //given
        LoginMvpView view = Mockito.mock(LoginMvpView.class);

        //when
        accountSuccessHandler.onLoginSuccess(view);

        //then
        verify(view).navigateToMainActivity();
        verify(view).hideLoading();
    }

    @Test
    void onLogoutSuccess() {
        //given
        MainMvpView view = Mockito.mock(MainMvpView.class);

        //when
        accountSuccessHandler.onLogoutSuccess(view);

        //then
        verify(view).hideLoading();
        verify(view).onLogout();
    }
}