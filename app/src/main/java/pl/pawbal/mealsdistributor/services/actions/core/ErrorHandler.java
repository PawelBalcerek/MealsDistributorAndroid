package pl.pawbal.mealsdistributor.services.actions.core;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public interface ErrorHandler {
    default void onError(String tag, String message, Throwable e) {
        Log.e(tag, message, e);
    }

    default void showToast(Context context, String tag, String message, Throwable e) {
        onError(tag, message, e);
        Toasty.error(context, message, Toast.LENGTH_SHORT, false).show();
    }
}
