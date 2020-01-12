package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.user.EditUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.LoginUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.services.rest.UserRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserWrapperServiceTest {
    @InjectMocks
    UserWrapperService userWrapperService;

    @Mock
    UserRestService userRestService;

    @Test
    void getCurrentUserInfo() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetUser> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetUser> getUserSingle = Mockito.mock(Single.class);
        when(userRestService.getCurrentUserInfo()).thenReturn(getUserSingle);

        //when
        userWrapperService.getCurrentUserInfo(observer);

        //then
        verify(userRestService).getCurrentUserInfo();
        verify(getUserSingle).subscribe(observer);
    }

    @Test
    void registerUser() {
        //given
        RegisterUser user = new RegisterUser();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(userRestService.registerUser(user)).thenReturn(single);

        //when
        userWrapperService.registerUser(user, observer);

        //then
        verify(userRestService).registerUser(user);
        verify(single).subscribe(observer);
    }

    @Test
    void loginUser() {
        //given
        LoginUser user = new LoginUser();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(userRestService.loginUser(user)).thenReturn(single);

        //when
        userWrapperService.loginUser(user, observer);

        //then
        verify(userRestService).loginUser(user);
        verify(single).subscribe(observer);
    }

    @Test
    void editCurrentUserInfo() {
        //given
        EditUser user = new EditUser();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(userRestService.editCurrentUserInfo(user)).thenReturn(single);

        //when
        userWrapperService.editCurrentUserInfo(user, observer);

        //then
        verify(userRestService).editCurrentUserInfo(user);
        verify(single).subscribe(observer);
    }
}