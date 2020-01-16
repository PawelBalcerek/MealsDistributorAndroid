package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.data.api.service.rest.UserRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserWrapperServiceTest {
    @InjectMocks
    UserWrapperService userWrapperService;

    @Mock
    UserRestService userRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void getCurrentUser() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetUser> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetUser> single = Mockito.mock(Single.class);
        when(userRestService.getCurrentUser()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        userWrapperService.getCurrentUser(observer);

        //then
        verify(userRestService).getCurrentUser();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
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
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        userWrapperService.registerUser(user, observer);

        //then
        verify(userRestService).registerUser(user);
        verify(singleWrapper).wrapSingle(single);
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
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        userWrapperService.editCurrentUser(user, observer);

        //then
        verify(userRestService).editCurrentUser(user);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getUser() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetUser> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetUser> single = Mockito.mock(Single.class);
        when(userRestService.getUser(id)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        userWrapperService.getUser(id, observer);

        //then
        verify(userRestService).getUser(id);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}