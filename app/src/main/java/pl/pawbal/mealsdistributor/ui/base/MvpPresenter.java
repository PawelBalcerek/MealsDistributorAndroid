package pl.pawbal.mealsdistributor.ui.base;

public interface MvpPresenter<V> {
    void onAttach(V mvpView);

    void onDetach();
}
