package pl.pawbal.mealsdistributor.data.service;

import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;

public interface ConfigurationService {
    void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer);

    void editRestaurant(EditConfiguration body, CustomSingleObserver<Void> observer);
}
