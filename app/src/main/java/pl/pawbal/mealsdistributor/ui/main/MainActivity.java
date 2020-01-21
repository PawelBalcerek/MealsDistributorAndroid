package pl.pawbal.mealsdistributor.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.FontManager;
import pl.pawbal.mealsdistributor.ui.base.BaseActivity;
import pl.pawbal.mealsdistributor.ui.home.HomeFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantFragment;

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
        attachHomeFragment();
        setUpTopBar();
        setUpNavigationView();
    }

    private void attachHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.fragment_wrapper, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit();
    }

    private void setUpTopBar() {
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME_SOLID);
        FontManager.markAsIconContainer(topBar, iconFont);
    }

    private void setUpNavigationView() {
        loginTextView = menuNavigationView.findViewById(R.id.tv_navigation_header_login);
        menuNavigationView.setNavigationItemSelectedListener(this::navigationItemSelectedAction);
    }

    private boolean navigationItemSelectedAction(MenuItem item) {
        this.closeMenu();
        switch (item.getItemId()) {
            case R.id.mi_navigation_home:
                presenter.onNavigateToHome();
                return true;
            case R.id.mi_navigation_restaurant:
                presenter.onNavigateToRestaurant();
                return true;
            default:
                return false;
        }
    }

    @OnClick(R.id.tv_default_menu)
    void openMenu() {
        menuDrawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeMenu() {
        menuDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void navigateToHomeActivity() {
        Fragment fromStack = getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
        if (fromStack == null) {
            Fragment fragment = HomeFragment.newInstance();
            replaceFragment(fragment, HomeFragment.TAG);
        } else
            replaceFragment(fromStack, HomeFragment.TAG);
    }

    private void replaceFragment(Fragment fragment, String fragmentTag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_wrapper, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void navigateToRestaurantActivity() {
        Fragment fromStack = getSupportFragmentManager().findFragmentByTag(RestaurantFragment.TAG);
        if (fromStack == null) {
            Fragment fragment = RestaurantFragment.newInstance();
            replaceFragment(fragment, RestaurantFragment.TAG);
        } else
            replaceFragment(fromStack, RestaurantFragment.TAG);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
