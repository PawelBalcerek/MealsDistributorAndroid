package pl.pawbal.mealsdistributor.services;

import pl.pawbal.mealsdistributor.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface ConfigurationService {
    void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer);

    void editRestaurant(EditConfiguration body, CustomSingleObserver<Void> observer);
}
