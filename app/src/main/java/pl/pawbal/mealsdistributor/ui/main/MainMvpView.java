package pl.pawbal.mealsdistributor.ui.main;

import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface MainMvpView extends MvpView {
    void bindUserToMenu(GetUser user);

    void closeMenu();

    void navigateToHomeFragment();

    void navigateToRestaurantFragment();

    void logout();

    void onLogout();
}
