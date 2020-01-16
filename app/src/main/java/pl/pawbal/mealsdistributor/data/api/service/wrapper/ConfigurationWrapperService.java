package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.ConfigurationService;
import pl.pawbal.mealsdistributor.data.api.service.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;

@Singleton
public class ConfigurationWrapperService implements ConfigurationService {
    private final ConfigurationRestService configurationRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    ConfigurationWrapperService(ConfigurationRestService configurationRestService,
                                SingleWrapper singleWrapper) {
        this.configurationRestService = configurationRestService;
        this.singleWrapper = singleWrapper;
    }

    @Override
    public void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer) {
        singleWrapper.wrapSingle(configurationRestService.getConfiguration(key))
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditConfiguration body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(configurationRestService.editConfiguration(body))
                .subscribe(observer);
    }
}
