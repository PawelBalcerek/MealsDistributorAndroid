package pl.pawbal.mealsdistributor.config;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static pl.pawbal.mealsdistributor.util.gson.CustomGsonBuilder.gson;

@Singleton
public class RestConfiguration {
    private static final String API_URL = "apiUrl";

    private final ApplicationProperties applicationProperties;

    public RestConfiguration(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private String getBaseUrl() {
        return applicationProperties.getProperty(API_URL);
    }
}
