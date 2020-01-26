package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalTimeUtil {
    private static final String CUSTOM_LOCAL_TIME_PATTERN = "HH:mm";

    public static String format(int hourOfDay, int minute) {
        return LocalTime.of(hourOfDay, minute).format(DateTimeFormatter.ofPattern(CUSTOM_LOCAL_TIME_PATTERN));
    }

    @Nullable
    public static Long getMilliSec(@Nullable String localTime) {
        if (localTime == null) return null;
        return LocalTime.parse(localTime, DateTimeFormatter.ofPattern(CUSTOM_LOCAL_TIME_PATTERN))
                .atDate(LocalDate.now())
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}
