package pl.pawbal.mealsdistributor.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.models.dto.factory.AccountFactory;
import pl.pawbal.mealsdistributor.data.models.dto.factory.UserFactory;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.home.HomeMvpPresenter;
import pl.pawbal.mealsdistributor.ui.home.HomeMvpView;
import pl.pawbal.mealsdistributor.ui.home.HomePresenter;
import pl.pawbal.mealsdistributor.ui.login.LoginMvpPresenter;
import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;
import pl.pawbal.mealsdistributor.ui.login.LoginPresenter;
import pl.pawbal.mealsdistributor.ui.main.MainMvpPresenter;
import pl.pawbal.mealsdistributor.ui.main.MainMvpView;
import pl.pawbal.mealsdistributor.ui.main.MainPresenter;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpPresenter;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.MealPresenter;
import pl.pawbal.mealsdistributor.ui.register.RegisterMvpPresenter;
import pl.pawbal.mealsdistributor.ui.register.RegisterMvpView;
import pl.pawbal.mealsdistributor.ui.register.RegisterPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpPresenter;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantPresenter;

@Module
public class ActivityModule {
    private final AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity provideAppCompatActivity() {
        return appCompatActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginMvpPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    RegisterMvpPresenter<RegisterMvpView> provideRegisterMvpPresenter(RegisterPresenter<RegisterMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    HomeMvpPresenter<HomeMvpView> provideHomeMvpPresenter(HomePresenter<HomeMvpView> presenter) {
        return presenter;
    }

    @Provides
    RestaurantMvpPresenter<RestaurantMvpView> provideRestaurantMvpPresenter(RestaurantPresenter<RestaurantMvpView> presenter) {
        return presenter;
    }

    @Provides
    AddRestaurantMvpPresenter<AddRestaurantMvpView> provideAddRestaurantMvpPresenter(AddRestaurantPresenter<AddRestaurantMvpView> presenter) {
        return presenter;
    }

    @Provides
    RestaurantDetailsMvpPresenter<RestaurantDetailsMvpView> provideRestaurantDetailsMvpPresenter(RestaurantDetailsPresenter<RestaurantDetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    EditRestaurantMvpPresenter<EditRestaurantMvpView> provideEditRestaurantMvpPresenter(EditRestaurantPresenter<EditRestaurantMvpView> presenter) {
        return presenter;
    }

    @Provides
    MealMvpPresenter<MealMvpView> provideMealMvpPresenter(MealPresenter<MealMvpView> presenter) {
        return presenter;
    }

    // Factories

    @Provides
    AccountFactory provideAccountFactory() {
        return new AccountFactory();
    }

    @Provides
    UserFactory providesUserFactory() {
        return new UserFactory();
    }

    @Provides
    RestaurantBundleFactory provideRestaurantBundleFactory() {
        return new RestaurantBundleFactory();
    }

    // Other (Core, Common, etc.)

    @Provides
    SuccessHandler provideSuccessHandler() {
        return new SuccessHandler();
    }

    @Provides
    ErrorHandler provideErrorHandler() {
        return new ErrorHandler();
    }
}
