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
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.ui.FontManager;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.ui.base.BaseActivity;
import pl.pawbal.mealsdistributor.ui.home.HomeFragment;
import pl.pawbal.mealsdistributor.ui.login.LoginActivity;
import pl.pawbal.mealsdistributor.ui.orderproposition.OrderPropositionFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantFragment;
import pl.pawbal.mealsdistributor.util.FragmentUtil;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @BindView(R.id.cl_default_topBar)
    CoordinatorLayout topBar;

    @BindView(R.id.dl_main_menu)
    DrawerLayout menuDrawerLayout;

    @BindView(R.id.nv_main_menu)
    NavigationView menuNavigationView;

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
        menuNavigationView.setNavigationItemSelectedListener(this::navigationItemSelectedAction);
        presenter.getCurrentUser();
    }

    @Override
    public void bindUserToMenu(GetUser user) {
        TextView login = menuNavigationView.findViewById(R.id.tv_navigation_header_login);
        login.setText(user.getEmail().split("@")[0]);
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
            case R.id.mi_navigation_order_proposition:
                presenter.onNavigateToOrderProposition();
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
    public void navigateToHomeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(HomeFragment.TAG);
        FragmentUtil.navigateToFragment(null, fragmentManager, fromStack,
                RestaurantFragment.newInstance(), HomeFragment.TAG);
    }

    @Override
    public void navigateToRestaurantFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(RestaurantFragment.TAG);
        FragmentUtil.navigateToFragment(null, fragmentManager, fromStack,
                RestaurantFragment.newInstance(), RestaurantFragment.TAG);
    }

    @Override
    public void navigateToOrderPropositionFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(OrderPropositionFragment.TAG);
        FragmentUtil.navigateToFragment(null, fragmentManager, fromStack,
                OrderPropositionFragment.newInstance(), OrderPropositionFragment.TAG);
    }

    @Override
    @OnClick(R.id.tv_logout)
    public void logout() {
        presenter.logout();
    }

    @Override
    public void onLogout() {
        Intent intent = LoginActivity.getStartIntent(MainActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
