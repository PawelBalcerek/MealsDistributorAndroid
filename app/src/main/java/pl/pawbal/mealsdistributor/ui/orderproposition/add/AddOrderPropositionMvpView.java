package pl.pawbal.mealsdistributor.ui.orderproposition.add;

import java.util.List;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface AddOrderPropositionMvpView extends MvpView {
    void bindRestaurants(List<Restaurant> restaurants);

    void goBack();
}
