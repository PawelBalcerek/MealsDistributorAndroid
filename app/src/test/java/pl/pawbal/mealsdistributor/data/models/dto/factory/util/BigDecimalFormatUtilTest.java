package pl.pawbal.mealsdistributor.data.models.dto.factory.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BigDecimalFormatUtilTest {
    private final BigDecimalFormatUtil util = new BigDecimalFormatUtil();

    @Test
    void format() {
        //given
        String decimal = "0.01";
        BigDecimal expected = new BigDecimal("0.01");

        //when
        BigDecimal result = util.format(decimal);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void formatWhenNullOrEmpty(boolean nullDecimal) {
        //given
        String decimal = nullDecimal ? null : "";

        //when
        BigDecimal result = util.format(decimal);

        //then
        assertNull(result);
    }
}