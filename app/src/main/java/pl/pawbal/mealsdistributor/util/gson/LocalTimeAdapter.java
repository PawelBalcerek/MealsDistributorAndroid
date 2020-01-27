package pl.pawbal.mealsdistributor.util.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static pl.pawbal.mealsdistributor.util.LocalDateTimeUtil.LOCAL_DATE_TIME_CUSTOM_FORMAT;
import static pl.pawbal.mealsdistributor.util.LocalTimeUtil.LOCAL_TIME_CUSTOM_FORMAT;

public class LocalTimeAdapter extends TypeAdapter<LocalTime> {
    @Override
    public void write(JsonWriter out, LocalTime value) throws IOException {
        out.value(DateTimeFormatter.ofPattern(LOCAL_TIME_CUSTOM_FORMAT).format(value));
    }

    @Override
    public LocalTime read(JsonReader in) throws IOException {
        return LocalTime.parse(in.nextString(), DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CUSTOM_FORMAT));
    }
}
