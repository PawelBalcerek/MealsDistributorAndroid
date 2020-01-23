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
    public BigDecimal format(@Nullable String decimal) throws NumberFormatException {
        if (decimal == null || decimal.isEmpty())
            return null;
        decimal = decimal.replace(",", ".");
        return new BigDecimal(decimal);
    }

    @Nullable
    public static String format(@Nullable BigDecimal decimal) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return decimal != null ?
                numberFormat.format(decimal) :
                null;
    }

    @Nullable
    public static String formatWithCurrency(@Nullable BigDecimal decimal) {
        return decimal != null ?
                NumberFormat.getCurrencyInstance(new Locale("pl", "PL")).format(decimal) :
                null;
    }
}
