package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.user.EditCurrentUser;
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
    void getCurrentUser() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetUser> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetUser> getUserSingle = Mockito.mock(Single.class);
        when(userRestService.getCurrentUser()).thenReturn(getUserSingle);

        //when
        userWrapperService.getCurrentUser(observer);

        //then
        verify(userRestService).getCurrentUser();
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
    void editCurrentUser() {
        //given
        EditCurrentUser user = new EditCurrentUser();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(userRestService.editCurrentUser(user)).thenReturn(single);

        //when
        userWrapperService.editCurrentUser(user, observer);

        //then
        verify(userRestService).editCurrentUser(user);
        verify(single).subscribe(observer);
    }
}