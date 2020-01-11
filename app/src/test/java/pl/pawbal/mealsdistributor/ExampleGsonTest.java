package pl.pawbal.mealsdistributor;

import com.google.gson.Gson;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleGsonTest {

    @Test
    @Disabled("Just testing how library works. :)")
    void testGson() {
        //given
        String testJson = "{\"key\": \"key\", \"value\": \"value\"}";

        //when
        GetConfiguration result = new Gson().fromJson(testJson, GetConfiguration.class);

        //then
        assertEquals("key", result.getKey());
        assertEquals("value", result.getValue());
    }
}
