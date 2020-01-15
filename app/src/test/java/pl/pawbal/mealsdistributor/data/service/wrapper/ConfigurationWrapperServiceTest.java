package pl.pawbal.mealsdistributor.data.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.data.service.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigurationWrapperServiceTest {
    @InjectMocks
    ConfigurationWrapperService configurationWrapperService;

    @Mock
    ConfigurationRestService configurationRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void getConfiguration() {
        //given
        String key = "key";
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetConfiguration> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetConfiguration> single = Mockito.mock(Single.class);
        when(configurationRestService.getConfiguration(key)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        configurationWrapperService.getConfiguration(key, observer);

        //then
        verify(configurationRestService).getConfiguration(key);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void putConfiguration() {
        //given
        EditConfiguration body = new EditConfiguration();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(configurationRestService.editConfiguration(body)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        configurationWrapperService.editRestaurant(body, observer);

        //then
        verify(configurationRestService).editConfiguration(body);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}