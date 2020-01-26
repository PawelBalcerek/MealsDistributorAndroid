package pl.pawbal.mealsdistributor.service;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import pl.pawbal.mealsdistributor.R;

public final class ActivityCommonService {
    private ActivityCommonService() {
    }

    public static AlertDialog showLoadingDialog(Context context) {
        AlertDialog progressDialog = new AlertDialog.Builder(context).create();
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
