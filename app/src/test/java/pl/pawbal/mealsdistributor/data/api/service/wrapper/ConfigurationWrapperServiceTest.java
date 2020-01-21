package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Completable;
import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.api.service.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigurationWrapperServiceTest {
    @InjectMocks
    ConfigurationWrapperService configurationWrapperService;

    @Mock
    ConfigurationRestService configurationRestService;

    @Mock
    ResponseWrapper responseWrapper;

    @Test
    void getConfiguration() {
        //given
        String key = "key";
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetConfiguration> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetConfiguration> single = Mockito.mock(Single.class);
        when(configurationRestService.getConfiguration(key)).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        configurationWrapperService.getConfiguration(key, observer);

        //then
        verify(configurationRestService).getConfiguration(key);
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void putConfiguration() {
        //given
        EditConfiguration body = new EditConfiguration();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(configurationRestService.editConfiguration(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        configurationWrapperService.editRestaurant(body, observer);

        //then
        verify(configurationRestService).editConfiguration(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }
}