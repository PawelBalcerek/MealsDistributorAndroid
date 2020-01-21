package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.login.LoginMvpView;
import retrofit2.HttpException;

public class AccountErrorHandler {
    private final String TAG = AccountErrorHandler.class.toString();
    private final Context context;
    private final ErrorHandler errorHandler;

    @Inject
    public AccountErrorHandler(@ActivityContext Context context,
                               ErrorHandler errorHandler) {
        this.context = context;
        this.errorHandler = errorHandler;
    }

    // TODO: May be unit tested
    public void onLoginError(Throwable t, LoginMvpView view) {
        view.hideLoading();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.onError(TAG, "Bad request", t);
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.login_default_error_toast), t);
                    break;
                case 404:
                    errorHandler.onError(TAG, "Not found", t);
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.login_default_error_toast), t);
                    break;
                case 500:
                    errorHandler.onError(TAG, "Internal server error", t);
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.login_default_error_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.login_default_error_toast), t);
            }
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.login_default_error_toast), t);
        }
    }
}
