package pl.pawbal.mealsdistributor.data.api.service;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.response.config.GetConfiguration;

public interface ConfigurationService {
    void getConfiguration(String key, CustomSingleObserver<GetConfiguration> observer);

    void editRestaurant(EditConfiguration body, CustomCompletableObserver observer);
}
