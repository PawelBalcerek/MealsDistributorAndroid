package pl.pawbal.mealsdistributor.ui.orderproposition.add;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface AddOrderPropositionMvpPresenter<V> extends MvpPresenter<V> {
    void getRestaurants();

    void addOrderProposition(String restaurantId, Long orderTime);
}
