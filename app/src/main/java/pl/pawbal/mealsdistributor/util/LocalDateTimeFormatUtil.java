package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    @Nullable
    public static String format(@Nullable LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("pl", "PL")).format(localDateTime);
    }
}
