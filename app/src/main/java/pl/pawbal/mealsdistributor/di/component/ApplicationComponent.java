package pl.pawbal.mealsdistributor.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pl.pawbal.mealsdistributor.MDApplication;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.ConfigurationService;
import pl.pawbal.mealsdistributor.data.api.service.MealService;
import pl.pawbal.mealsdistributor.data.api.service.OrderPositionService;
import pl.pawbal.mealsdistributor.data.api.service.OrderPropositionService;
import pl.pawbal.mealsdistributor.data.api.service.OrderService;
import pl.pawbal.mealsdistributor.data.api.service.RestaurantService;
import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.di.ApplicationContext;
import pl.pawbal.mealsdistributor.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MDApplication mdApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    AccountService getAccountService();

    ConfigurationService getConfigurationService();

    MealService getMealService();

    OrderPositionService getOrderPositionService();

    OrderPropositionService getOrderPropositionService();

    OrderService getOrderService();

    RestaurantService getRestaurantService();

    UserService getUserService();
}
