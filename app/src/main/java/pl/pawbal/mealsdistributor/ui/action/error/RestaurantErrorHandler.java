package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;

public class RestaurantErrorHandler {
    private final static String TAG = RestaurantErrorHandler.class.toString();
    private final ErrorHandler errorHandler;
    private final Context context;

    @Inject
    public RestaurantErrorHandler(ErrorHandler errorHandler,
                                  @ActivityContext Context context) {
        this.errorHandler = errorHandler;
        this.context = context;
    }

    // TODO: May be unit tested
    public void onGetRestaurantsError(Throwable t, RestaurantMvpView view) {
        view.hideLoading();
        errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurants_default_error_toast), t);
    }
}
