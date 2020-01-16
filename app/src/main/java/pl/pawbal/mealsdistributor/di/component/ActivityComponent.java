package pl.pawbal.mealsdistributor.di.component;

import dagger.Component;
import pl.pawbal.mealsdistributor.di.PerActivity;
import pl.pawbal.mealsdistributor.di.module.ActivityModule;
import pl.pawbal.mealsdistributor.ui.login.LoginActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
