package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalTimeUtil {
    public static final String LOCAL_TIME_CUSTOM_FORMAT = "HH:mm";

    public static String format(int hourOfDay, int minute) {
        return LocalTime.of(hourOfDay, minute).format(DateTimeFormatter.ofPattern(LOCAL_TIME_CUSTOM_FORMAT));
    }

    @Nullable
    public static Long getMilliSec(@Nullable String localTime) {
        if (localTime == null) return null;
        return LocalTime.parse(localTime, DateTimeFormatter.ofPattern(LOCAL_TIME_CUSTOM_FORMAT))
                .atDate(LocalDate.now())
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}
