package pl.pawbal.mealsdistributor.config;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestConfiguration {
    private static final String API_URL = "apiUrl";
    private static final String DEFAULT_API_URL = "http://localhost";

    private final Context context;

    public RestConfiguration(Context context) {
        this.context = context;
    }

    public Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private String getBaseUrl() {
        try {
            return new ApplicationProperties(context).getProperty(API_URL);
        } catch (IOException e) {
            Log.e("CONFIG", "Couldn't initialize ApplicationProperties class", e);
            Log.e("CONFIG", String.format("Returns default API URL: %s", DEFAULT_API_URL));
            return DEFAULT_API_URL;
        }
    }
}
