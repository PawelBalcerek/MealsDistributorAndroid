package pl.pawbal.mealsdistributor.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.pawbal.mealsdistributor.config.rest.RestConfiguration;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.ConfigurationService;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.OrderPositionService;
import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionPositionService;
import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.OrderService;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.rest.AccountRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.ConfigurationRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.MealRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.data.api.service.rest.UserRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.AccountWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.ConfigurationWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.MealWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.OrderPositionWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.OrderPropositionPositionWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.OrderPropositionWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.OrderWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.RestaurantWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.UserWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.preference.AppPreferenceHelper;
import pl.pawbal.mealsdistributor.data.preference.PreferenceHelper;
import pl.pawbal.mealsdistributor.di.ApplicationContext;
import pl.pawbal.mealsdistributor.di.PreferenceInfo;

import static pl.pawbal.mealsdistributor.data.preference.AppPreferenceHelper.APP_PREFERENCE_FILE_NAME;

@Module
public class ApplicationModule {
    private static final String TAG = "ApplicationModule";
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    // Configurations

    @Provides
    Properties provideProperties(@ApplicationContext Context context) {
        return loadProperties(context);
    }

    private Properties loadProperties(Context context) {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open("application.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            Log.e(TAG, "loadProperties", e);
        }
        return properties;
    }

    // API Services
    @Provides
    @Singleton
    ResponseWrapper provideSingleWrapper() {
        return new ResponseWrapper();
    }

    @Provides
    @Singleton
    AccountService provideAccountService(AccountWrapperService accountWrapperService) {
        return accountWrapperService;
    }

    @Provides
    AccountRestService provideAccountRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(AccountRestService.class);
    }

    @Provides
    @Singleton
    ConfigurationService provideConfigurationService(ConfigurationWrapperService configurationWrapperService) {
        return configurationWrapperService;
    }

    @Provides
    ConfigurationRestService provideConfigurationRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(ConfigurationRestService.class);
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return APP_PREFERENCE_FILE_NAME;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(AppPreferenceHelper appPreferenceHelper) {
        return appPreferenceHelper;
    }

    @Provides
    @Singleton
    MealService provideMealService(MealWrapperService mealWrapperService) {
        return mealWrapperService;
    }

    @Provides
    MealRestService provideMealRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(MealRestService.class);
    }

    @Provides
    @Singleton
    OrderPositionService provideOrderPositionService(OrderPositionWrapperService orderPositionWrapperService) {
        return orderPositionWrapperService;
    }

    @Provides
    OrderPositionRestService provideOrderPositionRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(OrderPositionRestService.class);
    }

    @Provides
    @Singleton
    OrderPropositionPositionService provideOrderPropositionPositionService(OrderPropositionPositionWrapperService orderPropositionPositionWrapperService) {
        return orderPropositionPositionWrapperService;
    }

    @Provides
    OrderPropositionPositionRestService provideOrderPropositionPositionRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(OrderPropositionPositionRestService.class);
    }

    @Provides
    @Singleton
    OrderPropositionService provideOrderPropositionWrapperService(OrderPropositionWrapperService orderPropositionWrapperService) {
        return orderPropositionWrapperService;
    }

    @Provides
    OrderPropositionRestService provideOrderPropositionRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(OrderPropositionRestService.class);
    }

    @Provides
    @Singleton
    OrderService provideOrderService(OrderWrapperService orderWrapperService) {
        return orderWrapperService;
    }

    @Provides
    OrderRestService provideOrderRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(OrderRestService.class);
    }

    @Provides
    @Singleton
    RestaurantService provideRestaurantService(RestaurantWrapperService restaurantWrapperService) {
        return restaurantWrapperService;
    }

    @Provides
    RestaurantRestService provideRestaurantRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(RestaurantRestService.class);
    }

    @Provides
    @Singleton
    UserService provideUserService(UserWrapperService userWrapperService) {
        return userWrapperService;
    }

    @Provides
    UserRestService provideUserRestService(RestConfiguration restConfiguration) {
        return restConfiguration.create()
                .create(UserRestService.class);
    }
}
