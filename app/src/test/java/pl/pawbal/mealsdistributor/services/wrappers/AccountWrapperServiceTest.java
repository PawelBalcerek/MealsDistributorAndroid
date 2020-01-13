package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.services.rest.AccountRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountWrapperServiceTest {
    @InjectMocks
    AccountWrapperService accountWrapperService;

    @Mock
    AccountRestService accountRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void login() {
        //given
        Login body = new Login();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(accountRestService.login(body)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        accountWrapperService.login(body, observer);

        //then
        verify(accountRestService).login(body);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void logout() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(accountRestService.logout()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        accountWrapperService.logout(observer);

        //then
        verify(accountRestService).logout();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}