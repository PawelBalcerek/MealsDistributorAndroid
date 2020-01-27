package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import java.time.DateTimeException;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.base.MvpView;
import pl.pawbal.mealsdistributor.ui.orderproposition.add.AddOrderPropositionMvpView;
import retrofit2.HttpException;

public class OrderPropositionErrorHandler {
    public static final String TAG = OrderPropositionErrorHandler.class.toString();
    private final ErrorHandler errorHandler;
    private final Context context;

    @Inject
    public OrderPropositionErrorHandler(ErrorHandler errorHandler,
                                        @ActivityContext Context context) {
        this.errorHandler = errorHandler;
        this.context = context;
    }

    public void onAddOrderPropositionError(Throwable t, AddOrderPropositionMvpView view) {
        view.hideLoading();
        view.hideKeyboard();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_order_proposition_400_error_toast), t);
                    break;
                case 404:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_order_proposition_404_error_toast), t);
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_order_proposition_default_error_toast), t);
                    break;
            }
        } else if (t instanceof DateTimeException) {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_order_proposition_dte_error_toast), t);
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_order_proposition_default_error_toast), t);
        }
    }

    public void onGetAvailableOrderPropositionsError(Throwable t, MvpView view) {
        view.hideLoading();
        errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_available_order_propositions_default_error_toast), t);
    }
}
