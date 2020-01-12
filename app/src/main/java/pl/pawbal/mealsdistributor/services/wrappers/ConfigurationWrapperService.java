package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.services.ConfigurationService;
import pl.pawbal.mealsdistributor.services.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public class ConfigurationWrapperService implements ConfigurationService {
    private final ConfigurationRestService configurationRestService;

    // Used for mocking
    @SuppressWarnings("WeakerAccess")
    ConfigurationWrapperService(ConfigurationRestService configurationRestService) {
        this.configurationRestService = configurationRestService;
    }

    public ConfigurationWrapperService(Context context) {
        this(new RestConfiguration(context).create()
                .create(ConfigurationRestService.class));
    }

    @Override
    public void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer) {
        configurationRestService.getConfiguration(key)
                .subscribe(observer);
    }

    @Override
    public void editRestaurant(EditConfiguration body, CustomSingleObserver<Void> observer) {
        configurationRestService.editConfiguration(body)
                .subscribe(observer);
    }
}
