package pl.pawbal.mealsdistributor.ui.action.success;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.ui.orderproposition.add.AddOrderPropositionMvpView;

public class OrderPropositionSuccessHandler {
    @Inject
    public OrderPropositionSuccessHandler() {
    }

    public void onAddOrderPropositionSuccess(AddOrderPropositionMvpView view) {
        view.hideLoading();
        view.goBack();
    }
}
