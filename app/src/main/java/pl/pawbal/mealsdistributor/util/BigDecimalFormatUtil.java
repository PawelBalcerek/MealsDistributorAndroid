package pl.pawbal.mealsdistributor.util;

import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.inject.Inject;

public class BigDecimalFormatUtil {
    @Inject
    public BigDecimalFormatUtil() {
    }

    @Nullable
    public BigDecimal format(@Nullable String decimal) {
        return decimal != null && !decimal.isEmpty() ?
                new BigDecimal(decimal) :
                null;
    }

    @Nullable
    public static String format(@Nullable BigDecimal decimal) {
        return decimal != null ?
                NumberFormat.getCurrencyInstance(new Locale("pl", "PL")).format(decimal) :
                null;
    }
}
