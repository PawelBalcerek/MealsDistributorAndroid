package pl.pawbal.mealsdistributor.ui.register;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface RegisterMvpPresenter<V> extends MvpPresenter<V> {
    void register(String email, String password, String confirmPassword);
}
