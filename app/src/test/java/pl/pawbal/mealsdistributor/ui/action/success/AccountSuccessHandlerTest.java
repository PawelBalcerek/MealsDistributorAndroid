package pl.pawbal.mealsdistributor.ui.action.success;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;

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
    }
}