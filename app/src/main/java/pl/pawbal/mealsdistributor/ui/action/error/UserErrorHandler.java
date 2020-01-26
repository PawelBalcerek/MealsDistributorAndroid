package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.main.MainMvpView;
import pl.pawbal.mealsdistributor.ui.register.RegisterMvpView;
import retrofit2.HttpException;

public class UserErrorHandler {
    private final String TAG = UserErrorHandler.class.toString();
    private final Context context;
    private final ErrorHandler errorHandler;

    @Inject
    public UserErrorHandler(@ActivityContext Context context,
                            ErrorHandler errorHandler) {
        this.context = context;
        this.errorHandler = errorHandler;
    }

    // TODO: May be unit tested
    public void onRegisterUserError(Throwable t, RegisterMvpView view) {
        view.hideLoading();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.register_error_400_toast), t);
                    break;
                case 409:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.register_error_409_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.register_default_error_toast), t);
                    break;
            }
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.register_default_error_toast), t);
        }
    }

    public void onGetCurrentUserError(Throwable t, MainMvpView view) {
        view.logout();
        view.hideLoading();
        if (t instanceof HttpException) {
            if (((HttpException) t).code() == 401) {
                errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_current_user_error_401_toast), t);
            } else {
                errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_current_user_default_error_toast), t);
            }
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_current_user_default_error_toast), t);
        }
    }
}
