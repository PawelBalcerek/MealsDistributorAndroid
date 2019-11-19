package pl.pawbal.mealsdistributor;

import com.google.gson.Gson;

import org.junit.Ignore;
import org.junit.Test;

import pl.pawbal.mealsdistributor.models.dto.response.config.GetConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleGsonTest {

    @Test
    @Ignore("Just testing how library works. :)")
    public void testGson() {
        //given
        String testJson = "{\"key\": \"key\", \"value\": \"value\"}";

        //when
        GetConfiguration result = new Gson().fromJson(testJson, GetConfiguration.class);

        //then
        assertEquals("key", result.getKey());
        assertEquals("value", result.getValue());
    }
}
