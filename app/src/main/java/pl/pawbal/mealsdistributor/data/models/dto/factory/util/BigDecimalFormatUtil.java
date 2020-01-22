package pl.pawbal.mealsdistributor.data.models.dto.factory.util;

import androidx.annotation.Nullable;

import java.math.BigDecimal;

import javax.inject.Inject;

public class BigDecimalFormatUtil {
    @Inject
    public BigDecimalFormatUtil() {
    }

    public BigDecimal format(@Nullable String decimal) {
        return decimal != null && !decimal.isEmpty() ?
                new BigDecimal(decimal) :
                null;
    }
}
