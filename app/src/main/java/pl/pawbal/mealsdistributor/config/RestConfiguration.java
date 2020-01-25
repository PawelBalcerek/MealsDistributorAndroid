package pl.pawbal.mealsdistributor.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static pl.pawbal.mealsdistributor.util.LocalDateTimeFormatUtil.LOCAL_DATE_TIME_CUSTOM_FORMAT;

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

    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
                .create();
    }

    private String getBaseUrl() {
        return applicationProperties.getProperty(API_URL);
    }

    private static final class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CUSTOM_FORMAT).format(value));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString(), DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CUSTOM_FORMAT));
        }
    }
}
