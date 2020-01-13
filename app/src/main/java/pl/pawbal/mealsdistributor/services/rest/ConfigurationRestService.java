package pl.pawbal.mealsdistributor.services.rest;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.config.EditConfiguration;
import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ConfigurationRestService {
    String CONFIGURATIONS_BASE_PATH = "/configurations";

    @GET(CONFIGURATIONS_BASE_PATH + "/{key}")
    Single<GetConfiguration> getConfiguration(@Path("key") String key);

    @PUT(CONFIGURATIONS_BASE_PATH)
    Single<Void> editConfiguration(@Body EditConfiguration configuration);
}
