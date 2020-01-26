package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.ui.FontManager;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.meal.MealFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantFragment;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.FragmentUtil;

public class RestaurantDetailsFragment extends BaseFragment implements RestaurantDetailsMvpView {
    public static final String TAG = RestaurantDetailsFragment.class.toString();
    private Restaurant restaurant;

    @Inject
    RestaurantDetailsMvpPresenter<RestaurantDetailsMvpView> presenter;

    @BindView(R.id.tv_restaurant_details_icon)
    TextView utensilsIcon;

    @BindView(R.id.tv_restaurant_details_name)
    TextView restaurantName;

    @BindView(R.id.tv_restaurant_details_phone_number)
    TextView restaurantPhoneNumber;

    @BindView(R.id.tv_restaurant_details_min_order_cost)
    TextView restaurantMinOrderCost;

    @BindView(R.id.tv_restaurant_details_delivery_cost)
    TextView restaurantDeliveryCost;

    @BindView(R.id.tv_restaurant_details_max_paid_order_value)
    TextView restaurantMaxPaidOrderValue;

    @BindView(R.id.btn_restaurant_details_meals)
    MaterialButton goToMealsButton;

    public static RestaurantDetailsFragment newInstance() {
        Bundle args = new Bundle();
        RestaurantDetailsFragment fragment = new RestaurantDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            if (view != null) setUnbinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        setIcon();
        bindRestaurantDetails();
    }

    private void bindRestaurantDetails() {
        Bundle bundle = getArguments();
        presenter.getRestaurant(bundle);
    }

    private void setIcon() {
        Typeface iconFont = FontManager.getTypeface(requireContext(), FontManager.FONTAWESOME_SOLID);
        utensilsIcon.setTypeface(iconFont);
        goToMealsButton.setTypeface(iconFont);
    }

    @Override
    public void bindRestaurantDetails(GetRestaurant restaurant) {
        this.restaurant = restaurant.getRestaurant();
        restaurantName.setText(restaurant.getRestaurant().getName());
        restaurantPhoneNumber.setText(restaurant.getRestaurant().getPhoneNumber());
        String minOrderCost = BigDecimalFormatUtil.formatWithCurrency(restaurant.getRestaurant().getMinOrderCost());
        restaurantMinOrderCost.setText(minOrderCost != null ? minOrderCost : requireContext().getResources().getText(R.string.no_info));
        String deliveryCost = BigDecimalFormatUtil.formatWithCurrency(restaurant.getRestaurant().getDeliveryCost());
        restaurantDeliveryCost.setText(deliveryCost != null ? deliveryCost : requireContext().getResources().getText(R.string.no_info));
        String maxPaidOrderValue = BigDecimalFormatUtil.formatWithCurrency(restaurant.getRestaurant().getMaxPaidOrderValue());
        restaurantMaxPaidOrderValue.setText(maxPaidOrderValue != null ? maxPaidOrderValue : requireContext().getResources().getText(R.string.no_info));
    }

    @OnClick(R.id.btn_restaurant_details_delete)
    void deleteRestaurant() {
        presenter.deleteRestaurant(restaurant.getId());
    }

    @Override
    public void onRestaurantDelete() {
        requireFragmentManager().popBackStack();
    }

    @OnClick(R.id.btn_restaurant_details_edit)
    void navigateToEditRestaurantFragment() {
        presenter.navigateToEditRestaurant(restaurant);
    }

    @Override
    public void navigateToEditRestaurantFragment(Bundle bundle) {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(EditRestaurantFragment.TAG);
        FragmentUtil.navigateToFragment(bundle, fragmentManager, fromStack,
                EditRestaurantFragment.newInstance(), EditRestaurantFragment.TAG);
    }

    @OnClick(R.id.btn_restaurant_details_meals)
    void navigateToMealFragment() {
        presenter.navigateToMeals(restaurant.getId());
    }

    @Override
    public void navigateToMealFragment(Bundle bundle) {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(MealFragment.TAG);
        FragmentUtil.navigateToFragment(bundle, fragmentManager, fromStack,
                MealFragment.newInstance(), MealFragment.TAG);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
