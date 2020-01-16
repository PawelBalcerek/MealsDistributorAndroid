package pl.pawbal.mealsdistributor;

import android.app.Application;

import pl.pawbal.mealsdistributor.di.component.ApplicationComponent;
import pl.pawbal.mealsdistributor.di.component.DaggerApplicationComponent;
import pl.pawbal.mealsdistributor.di.module.ApplicationModule;

public class MDApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
