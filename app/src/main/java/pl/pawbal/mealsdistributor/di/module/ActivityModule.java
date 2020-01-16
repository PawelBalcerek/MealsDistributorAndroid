package pl.pawbal.mealsdistributor.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.models.dto.factory.AccountFactory;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.login.LoginMvpPresenter;
import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;
import pl.pawbal.mealsdistributor.ui.login.LoginPresenter;

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
    LoginMvpPresenter<LoginMvpView> provideLoginMvpPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    // Factories

    @Provides
    AccountFactory provideAccountFactory() {
        return new AccountFactory();
    }
}
