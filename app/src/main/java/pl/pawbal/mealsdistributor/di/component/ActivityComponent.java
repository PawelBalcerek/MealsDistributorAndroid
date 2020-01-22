package pl.pawbal.mealsdistributor.di.component;

import dagger.Component;
import pl.pawbal.mealsdistributor.di.PerActivity;
import pl.pawbal.mealsdistributor.di.module.ActivityModule;
import pl.pawbal.mealsdistributor.ui.home.HomeFragment;
import pl.pawbal.mealsdistributor.ui.login.LoginActivity;
import pl.pawbal.mealsdistributor.ui.main.MainActivity;
import pl.pawbal.mealsdistributor.ui.register.RegisterActivity;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantFragment;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);

    void inject(RestaurantFragment restaurantFragment);

    void inject(AddRestaurantFragment addRestaurantFragment);
}
