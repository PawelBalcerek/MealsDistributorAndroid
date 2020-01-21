package pl.pawbal.mealsdistributor.ui.main;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface MainMvpPresenter<V> extends MvpPresenter<V> {
    void onNavigateToHome();

    void onNavigateToRestaurant();
}
