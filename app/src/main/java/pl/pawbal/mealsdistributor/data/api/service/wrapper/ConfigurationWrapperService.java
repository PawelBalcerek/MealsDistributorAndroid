package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.ConfigurationService;
import pl.pawbal.mealsdistributor.data.api.service.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;

@Singleton
public class ConfigurationWrapperService implements ConfigurationService {
    private final ConfigurationRestService configurationRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    ConfigurationWrapperService(ConfigurationRestService configurationRestService,
                                ResponseWrapper responseWrapper) {
        this.configurationRestService = configurationRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer) {
        responseWrapper.wrapSingle(configurationRestService.getConfiguration(key))
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditConfiguration body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(configurationRestService.editConfiguration(body))
                .subscribe(observer);
    }
}
