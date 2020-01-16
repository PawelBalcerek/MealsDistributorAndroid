package pl.pawbal.mealsdistributor.ui.login;

import pl.pawbal.mealsdistributor.di.PerActivity;
import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V> extends MvpPresenter<V> {
    void loginClick(String email, String password);

    void goToRegisterClick();
}
