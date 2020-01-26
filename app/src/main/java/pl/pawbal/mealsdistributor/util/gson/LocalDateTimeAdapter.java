package pl.pawbal.mealsdistributor.util.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pl.pawbal.mealsdistributor.util.LocalDateTimeUtil.LOCAL_DATE_TIME_CUSTOM_FORMAT;

public final class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        out.value(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CUSTOM_FORMAT).format(value));
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        return LocalDateTime.parse(in.nextString(), DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CUSTOM_FORMAT));
    }
}
