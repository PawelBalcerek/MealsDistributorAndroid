package pl.pawbal.mealsdistributor.ui.action.success;

import android.content.Context;
import android.content.res.Resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.register.RegisterMvpView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserSuccessHandlerTest {
    @InjectMocks
    UserSuccessHandler userSuccessHandler;

    @Mock
    SuccessHandler successHandler;

    @Mock
    Context context;

    @Test
    void onRegisterUserSuccess() {
        //given
        RegisterMvpView view = Mockito.mock(RegisterMvpView.class);
        Resources resources = Mockito.mock(Resources.class);
        String message = "";
        when(context.getResources()).thenReturn(resources);
        when(resources.getString(R.string.register_success_toast)).thenReturn(message);

        //when
        userSuccessHandler.onRegisterUserSuccess(view);

        //then
        verify(successHandler).showToast(context, message);
        verify(view).navigateToLogin();
    }

}