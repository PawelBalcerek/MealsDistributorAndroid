package pl.pawbal.mealsdistributor.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomGsonBuilder {
    public static Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter().nullSafe())
                .create();
    }
}
