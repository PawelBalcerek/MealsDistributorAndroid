package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Completable;
import pl.pawbal.mealsdistributor.data.api.service.rest.AccountRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountWrapperServiceTest {
    @InjectMocks
    AccountWrapperService accountWrapperService;

    @Mock
    AccountRestService accountRestService;

    @Mock
    ResponseWrapper responseWrapper;

    @Test
    void login() {
        //given
        Login body = new Login();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(accountRestService.login(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        accountWrapperService.login(body, observer);

        //then
        verify(accountRestService).login(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }

    @Test
    void logout() {
        //given
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(accountRestService.logout()).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        accountWrapperService.logout(observer);

        //then
        verify(accountRestService).logout();
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }
}