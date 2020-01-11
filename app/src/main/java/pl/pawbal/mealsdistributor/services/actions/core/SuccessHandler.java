package pl.pawbal.mealsdistributor.services.actions.core;

import android.content.Context;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public interface SuccessHandler {
    default void showToast(Context context, String message) {
        Toasty.success(context, message, Toast.LENGTH_SHORT, false).show();
    }
}
