package pl.pawbal.mealsdistributor.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.Unbinder;
import pl.pawbal.mealsdistributor.MDApplication;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.di.component.DaggerActivityComponent;
import pl.pawbal.mealsdistributor.di.module.ActivityModule;
import pl.pawbal.mealsdistributor.service.ActivityCommonService;
import pl.pawbal.mealsdistributor.service.NetworkCommonService;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {
    private ActivityComponent activityComponent;
    private ProgressDialog progressDialog;
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
        progressDialog = ActivityCommonService.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.cancel();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkCommonService.isNetworkConnected(this);
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) unbinder.unbind();
        super.onDestroy();
    }

    protected abstract void setUp();
}
