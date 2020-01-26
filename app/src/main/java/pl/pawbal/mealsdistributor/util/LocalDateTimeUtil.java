package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.inject.Inject;

public class LocalDateTimeUtil {
    public static final String LOCAL_DATE_TIME_CUSTOM_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String LOCAL_DATE_CUSTOM_FORMAT = "dd MMM yyyy";

    @Inject
    public LocalDateTimeUtil() {
    }

    // TODO: may be unit tested
    @Nullable
    public LocalDateTime of(@Nullable Long epochMilliSec) throws DateTimeException {
        if (epochMilliSec == null) return null;
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliSec), ZoneId.systemDefault());
    }

    @Nullable
    public static String format(@Nullable LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return DateTimeFormatter.ofPattern(LOCAL_DATE_CUSTOM_FORMAT, new Locale("pl", "PL")).format(localDateTime);
    }

    @Nullable
    public static Long getMilliSec(@Nullable LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    @Nullable
    static Long getMilliSec(@Nullable String localDate) {
        if (localDate == null) return null;
        LocalDate ld = LocalDate.parse(localDate, DateTimeFormatter.ofPattern(LOCAL_DATE_CUSTOM_FORMAT));
        return getMilliSec(LocalDateTime.of(ld, LocalTime.MIDNIGHT));
    }
}
