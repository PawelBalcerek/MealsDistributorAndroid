package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.inject.Inject;

public class LocalDateTimeFormatUtil {
    public static final String LOCAL_DATE_TIME_CUSTOM_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Inject
    public LocalDateTimeFormatUtil() {
    }

    // TODO: may be unit tested
    @Nullable
    public LocalDateTime format(@Nullable Long epochMilliSec) throws DateTimeException {
        if (epochMilliSec == null) return null;
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliSec), ZoneId.systemDefault());
    }
}
