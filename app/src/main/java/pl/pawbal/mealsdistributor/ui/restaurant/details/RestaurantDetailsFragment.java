package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.FontManager;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;

public class RestaurantDetailsFragment extends BaseFragment implements RestaurantDetailsMvpView {
    public static final String TAG = RestaurantDetailsFragment.class.toString();
    private String restaurantId;

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
        presenter.bindGetRestaurant(bundle);
    }

    private void setIcon() {
        Typeface iconFont = FontManager.getTypeface(requireContext(), FontManager.FONTAWESOME_SOLID);
        FontManager.markAsIconContainer(utensilsIcon, iconFont);
    }

    @Override
    public void bindRestaurantDetails(GetRestaurant restaurant) {
        restaurantId = restaurant.getRestaurant().getId();
        restaurantName.setText(restaurant.getRestaurant().getName());
        restaurantPhoneNumber.setText(restaurant.getRestaurant().getPhoneNumber());
        String minOrderCost = BigDecimalFormatUtil.format(restaurant.getRestaurant().getMinOrderCost());
        restaurantMinOrderCost.setText(minOrderCost != null ? minOrderCost : requireContext().getResources().getText(R.string.no_info));
        String deliveryCost = BigDecimalFormatUtil.format(restaurant.getRestaurant().getDeliveryCost());
        restaurantDeliveryCost.setText(deliveryCost != null ? deliveryCost : requireContext().getResources().getText(R.string.no_info));
        String maxPaidOrderValue = BigDecimalFormatUtil.format(restaurant.getRestaurant().getMaxPaidOrderValue());
        restaurantMaxPaidOrderValue.setText(maxPaidOrderValue != null ? maxPaidOrderValue : requireContext().getResources().getText(R.string.no_info));
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
