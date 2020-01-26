package pl.pawbal.mealsdistributor.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.Unbinder;
import pl.pawbal.mealsdistributor.MDApplication;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.di.component.DaggerActivityComponent;
import pl.pawbal.mealsdistributor.di.module.ActivityModule;
import pl.pawbal.mealsdistributor.service.ActivityCommonService;
import pl.pawbal.mealsdistributor.service.NetworkCommonService;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {
    private ActivityComponent activityComponent;
    private AlertDialog alertDialog;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MDApplication) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void showLoading() {
        hideLoading();
        alertDialog = ActivityCommonService.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (alertDialog != null && alertDialog.isShowing()) alertDialog.cancel();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkCommonService.isNetworkConnected(this);
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null)
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) unbinder.unbind();
        super.onDestroy();
    }

    protected abstract void setUp();
}
