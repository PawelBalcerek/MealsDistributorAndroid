package pl.pawbal.mealsdistributor.config.properties;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationProperties {
    private final Properties properties;

    @Inject
    ApplicationProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
