package pl.pawbal.mealsdistributor.ui.action.error;

import android.content.Context;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.ActivityContext;
import pl.pawbal.mealsdistributor.ui.action.core.ErrorHandler;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpView;
import retrofit2.HttpException;

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

    // TODO: May be unit tested
    public void onAddRestaurantError(Throwable t, AddRestaurantMvpView view) {
        view.hideLoading();
        view.hideKeyboard();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_restaurant_400_error_toast), t);
                    break;
                case 403:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_restaurant_403_error_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_restaurant_default_error_toast), t);
                    break;
            }
        } else if (t instanceof NumberFormatException) {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_restaurant_nfe_error_toast), t);
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.add_restaurant_default_error_toast), t);
        }
    }

    // TODO: May be unit tested
    public void onGetRestaurantError(Throwable t, RestaurantDetailsMvpView view) {
        view.hideLoading();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 403:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurant_403_error_toast), t);
                    break;
                case 404:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurant_404_error_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurant_default_error_toast), t);
            }
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.get_restaurant_default_error_toast), t);
        }
    }

    // TODO: May be unit tested
    public void onDeleteRestaurantError(Throwable t, RestaurantDetailsMvpView view) {
        view.hideLoading();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 403:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.delete_restaurant_403_error_toast), t);
                    break;
                case 404:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.delete_restaurant_404_error_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.delete_restaurant_default_error_toast), t);
            }
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.delete_restaurant_default_error_toast), t);
        }
    }

    // TODO: May be unit tested
    public void onEditRestaurantError(Throwable t, EditRestaurantMvpView view) {
        view.hideLoading();
        if (t instanceof HttpException) {
            switch (((HttpException) t).code()) {
                case 400:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_400_error_toast), t);
                case 403:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_403_error_toast), t);
                    break;
                case 404:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_404_error_toast), t);
                    break;
                default:
                    errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_default_error_toast), t);
            }
        } else if (t instanceof NumberFormatException) {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_nfe_error_toast), t);
        } else {
            errorHandler.showToast(context, TAG, context.getResources().getString(R.string.edit_restaurant_default_error_toast), t);
        }
    }
}
