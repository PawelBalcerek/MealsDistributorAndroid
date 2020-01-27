package pl.pawbal.mealsdistributor.ui.orderproposition.available;

import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.ui.base.MvpView;

public interface AvailableOrderPropositionMvpView extends MvpView {
    void bind(GetAvailableOrderPropositions availableOrderPropositions);
}
