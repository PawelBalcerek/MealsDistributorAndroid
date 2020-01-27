package pl.pawbal.mealsdistributor.ui.orderproposition.available;

import pl.pawbal.mealsdistributor.ui.base.MvpPresenter;

public interface AvailableOrderPropositionMvpPresenter<V> extends MvpPresenter<V> {
    void getAvailableOrderPropositions();
}
