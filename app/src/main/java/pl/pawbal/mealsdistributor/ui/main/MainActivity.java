package pl.pawbal.mealsdistributor.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.FontManager;
import pl.pawbal.mealsdistributor.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @BindView(R.id.cl_default_topBar)
    CoordinatorLayout topBar;

    @BindView(R.id.dl_main_menu)
    DrawerLayout menuDrawerLayout;

    @BindView(R.id.nv_main_menu)
    NavigationView menuNavigationView;

    TextView loginTextView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }

    @Override
    protected void setUp() {
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
        setUpTopBar();
        setUpNavigationView();
    }

    private void setUpTopBar() {
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME_SOLID);
        FontManager.markAsIconContainer(topBar, iconFont);
    }

    private void setUpNavigationView() {
        loginTextView = menuNavigationView.findViewById(R.id.tv_navigation_header_login);
    }

    @OnClick(R.id.tv_default_menu)
    void openMenu() {
        menuDrawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeMenu() {
        menuDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
