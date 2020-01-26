package pl.pawbal.mealsdistributor.config.rest;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import pl.pawbal.mealsdistributor.config.properties.ApplicationProperties;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static pl.pawbal.mealsdistributor.util.gson.CustomGsonBuilder.gson;

@Singleton
public class RestConfiguration {
    private static final String API_URL = "apiUrl";

    private final ApplicationProperties applicationProperties;
    private final SendCookiesInterceptor sendCookiesInterceptor;
    private final ReceiveCookiesInterceptor receiveCookiesInterceptor;

    @Inject
    public RestConfiguration(ApplicationProperties applicationProperties,
                             SendCookiesInterceptor sendCookiesInterceptor,
                             ReceiveCookiesInterceptor receiveCookiesInterceptor) {
        this.applicationProperties = applicationProperties;
        this.sendCookiesInterceptor = sendCookiesInterceptor;
        this.receiveCookiesInterceptor = receiveCookiesInterceptor;
    }

    public Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient()
                        .newBuilder()
                        .addInterceptor(sendCookiesInterceptor)
                        .addInterceptor(receiveCookiesInterceptor)
                        .build())
                .build();
    }

    private String getBaseUrl() {
        return applicationProperties.getProperty(API_URL);
    }
}
