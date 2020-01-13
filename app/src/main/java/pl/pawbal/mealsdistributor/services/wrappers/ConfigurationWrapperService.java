package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.services.ConfigurationService;
import pl.pawbal.mealsdistributor.services.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

public class ConfigurationWrapperService implements ConfigurationService {
    private final ConfigurationRestService configurationRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    ConfigurationWrapperService(ConfigurationRestService configurationRestService,
                                SingleWrapper singleWrapper) {
        this.configurationRestService = configurationRestService;
        this.singleWrapper = singleWrapper;
    }

    public ConfigurationWrapperService(Context context) {
        this(new RestConfiguration(context).create()
                .create(ConfigurationRestService.class), SingleWrapper.singleWrapper());
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
