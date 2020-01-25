package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;

public class MealErrorHandler {
    public static final String TAG = MealErrorHandler.class.toString();
    private final ErrorHandler errorHandler;
    private final Context context;

    @Inject
    public MealErrorHandler(ErrorHandler errorHandler,
                            @ActivityContext Context context) {
        this.errorHandler = errorHandler;
        this.context = context;
    }

    // TODO: May be unit tested
    public void onGetMealsError(Throwable t, MealMvpView view) {
        view.hideLoading();
        errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurants_default_error_toast), t);
    }
}
