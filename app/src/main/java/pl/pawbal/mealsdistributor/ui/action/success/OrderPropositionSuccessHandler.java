package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.ui.orderproposition.add.AddOrderPropositionMvpView;
import pl.pawbal.mealsdistributor.ui.orderproposition.available.AvailableOrderPropositionMvpView;

public class OrderPropositionSuccessHandler {
    @Inject
    public OrderPropositionSuccessHandler() {
    }

    public void onAddOrderPropositionSuccess(AddOrderPropositionMvpView view) {
        view.hideLoading();
        view.goBack();
    }

    public void onGetAvailableOrderPropositionsSuccess(GetAvailableOrderPropositions availableOrderPropositions, AvailableOrderPropositionMvpView view) {
        view.hideLoading();
        view.bind(availableOrderPropositions);
    }
}
