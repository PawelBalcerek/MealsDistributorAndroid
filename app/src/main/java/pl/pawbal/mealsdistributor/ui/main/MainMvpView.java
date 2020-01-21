package pl.pawbal.mealsdistributor.ui.main;

import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface MainMvpView extends MvpView {
    void closeMenu();

    void navigateToHomeActivity();

    void navigateToRestaurantActivity();
}
