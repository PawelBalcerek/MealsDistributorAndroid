package pl.pawbal.mealsdistributor.config;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ApplicationProperties {
    private final Context context;
    private final Properties properties;

    // Used for mocking
    @SuppressWarnings("unused")
    ApplicationProperties(Context context,
                          Properties properties) {
        this.context = context;
        this.properties = properties;
    }

    ApplicationProperties(Context context) throws IOException {
        this.context = context;
        this.properties = loadProperties();
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("application.properties");
        properties.load(inputStream);
        return properties;
    }

    String getProperty(String key) {
        return properties.getProperty(key);
    }
}
