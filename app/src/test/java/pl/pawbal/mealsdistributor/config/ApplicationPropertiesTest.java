package pl.pawbal.mealsdistributor.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationPropertiesTest {
    @InjectMocks
    ApplicationProperties applicationProperties;

    @Mock
    Properties properties;

    @Test
    void getProperty() {
        //given
        String key = "key";
        String expected = "expected";
        when(properties.getProperty(key)).thenReturn(expected);

        //when
        String result = applicationProperties.getProperty(key);

        assertEquals(expected, result);
    }
}