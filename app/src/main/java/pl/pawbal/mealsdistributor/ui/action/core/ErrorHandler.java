package pl.pawbal.mealsdistributor.ui.action.core;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ErrorHandler {
    @SuppressWarnings("WeakerAccess")
    public void onError(String tag, String message, Throwable e) {
        Log.e(tag, message, e);
    }

    public void showToast(Context context, String tag, String message, Throwable e) {
        onError(tag, message, e);
        Toasty.error(context, message, Toast.LENGTH_SHORT, false).show();
    }
}
