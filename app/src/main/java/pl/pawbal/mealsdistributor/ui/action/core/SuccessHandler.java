package pl.pawbal.mealsdistributor.ui.action.core;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;

public class SuccessHandler {
    @Inject
    public SuccessHandler() {
    }

    public void showToast(Context context, String message) {
        Toasty.success(context, message, Toast.LENGTH_SHORT, false).show();
    }
}
