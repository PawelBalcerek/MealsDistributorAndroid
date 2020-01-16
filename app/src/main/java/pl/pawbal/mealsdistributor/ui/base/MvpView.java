package pl.pawbal.mealsdistributor.ui.base;

public interface MvpView {
    void showLoading();

    void hideLoading();

    boolean isNetworkConnected();
}
