package pl.pawbal.mealsdistributor.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationProperties {
    private final Properties properties;

    @Inject
    public ApplicationProperties(Properties properties) {
        this.properties = properties;
    }

    String getProperty(String key) {
        return properties.getProperty(key);
    }
}
