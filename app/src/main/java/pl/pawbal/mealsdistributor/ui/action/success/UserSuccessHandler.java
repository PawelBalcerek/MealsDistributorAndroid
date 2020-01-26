package pl.pawbal.mealsdistributor.ui.action.success;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.SuccessHandler;
import pl.pawbal.mealsdistributor.ui.main.MainMvpView;
import pl.pawbal.mealsdistributor.ui.register.RegisterMvpView;

public class UserSuccessHandler {
    private final Context context;
    private final SuccessHandler successHandler;

    @Inject
    UserSuccessHandler(@ActivityContext Context context, SuccessHandler successHandler) {
        this.context = context;
        this.successHandler = successHandler;
    }

    public void onRegisterUserSuccess(RegisterMvpView view) {
        view.hideLoading();
        successHandler.showToast(context, context.getResources().getString(R.string.register_success_toast));
        view.navigateToLogin();
    }

    public void onGetCurrentUserSuccess(GetUser user, MainMvpView view) {
        view.hideLoading();
        view.bindUserToMenu(user);
    }
}
