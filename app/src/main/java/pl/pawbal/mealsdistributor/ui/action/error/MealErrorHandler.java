package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import java.time.DateTimeException;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.meal.MealMvpView;
import pl.pawbal.mealsdistributor.ui.meal.add.AddMealMvpView;
import retrofit2.HttpException;

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

    // TODO: May be unit tested
    public void onAddMealError(Throwable t, AddMealMvpView view) {
        view.hideLoading();
        view.hideKeyboard();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_400_error_toast), t);
                    break;
                case 403:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_403_error_toast), t);
                    break;
                case 404:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_404_error_toast), t);
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_default_error_toast), t);
                    break;
            }
        } else if (t instanceof NumberFormatException) {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_nfe_error_toast), t);
        } else if (t instanceof DateTimeException) {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_dte_error_toast), t);
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_meal_default_error_toast), t);
        }
    }
}
