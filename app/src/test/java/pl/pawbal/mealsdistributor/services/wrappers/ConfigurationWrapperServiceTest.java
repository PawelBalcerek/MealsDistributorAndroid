package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.services.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigurationWrapperServiceTest {
    @InjectMocks
    ConfigurationWrapperService configurationWrapperService;

    @Mock
    ConfigurationRestService configurationRestService;

    @Test
    void getConfiguration() {
        //given
        String key = "key";
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetConfiguration> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetConfiguration> getConfigurationSingle = Mockito.mock(Single.class);
        when(configurationRestService.getConfiguration(key)).thenReturn(getConfigurationSingle);

        //when
        configurationWrapperService.getConfiguration(key, observer);

        //then
        verify(configurationRestService).getConfiguration(key);
        verify(getConfigurationSingle).subscribe(observer);
    }

    @Test
    void putConfiguration() {
        //given
        EditConfiguration body = new EditConfiguration();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> putConfigurationSingle = Mockito.mock(Single.class);
        when(configurationRestService.putConfiguration(body)).thenReturn(putConfigurationSingle);

        //when
        configurationWrapperService.putConfiguration(body, observer);

        //then
        verify(configurationRestService).putConfiguration(body);
        verify(putConfigurationSingle).subscribe(observer);
    }
}