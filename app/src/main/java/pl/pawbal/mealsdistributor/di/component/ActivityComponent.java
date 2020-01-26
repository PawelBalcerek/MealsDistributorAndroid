package pl.pawbal.mealsdistributor.di.component;

import dagger.Component;
import pl.pawbal.mealsdistributor.di.PerActivity;
import pl.pawbal.mealsdistributor.di.module.ActivityModule;
import pl.pawbal.mealsdistributor.ui.home.HomeFragment;
import pl.pawbal.mealsdistributor.ui.login.LoginActivity;
import pl.pawbal.mealsdistributor.ui.main.MainActivity;
import pl.pawbal.mealsdistributor.ui.meal.MealFragment;
import pl.pawbal.mealsdistributor.ui.meal.add.AddMealFragment;
import pl.pawbal.mealsdistributor.ui.meal.details.MealDetailsFragment;
import pl.pawbal.mealsdistributor.ui.meal.edit.EditMealFragment;
import pl.pawbal.mealsdistributor.ui.register.RegisterActivity;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantFragment;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);

    void inject(RestaurantFragment restaurantFragment);

    void inject(AddRestaurantFragment addRestaurantFragment);

    void inject(RestaurantDetailsFragment restaurantDetailsFragment);

    void inject(EditRestaurantFragment editRestaurantFragment);

    void inject(MealFragment mealFragment);

    void inject(AddMealFragment addMealFragment);

    void inject(MealDetailsFragment mealDetailsFragment);

    void inject(EditMealFragment editMealFragment);
}
