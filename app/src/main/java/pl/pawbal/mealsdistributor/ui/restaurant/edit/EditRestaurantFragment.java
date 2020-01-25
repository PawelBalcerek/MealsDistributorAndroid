package pl.pawbal.mealsdistributor.ui.restaurant.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.ViewValueUtil;

public class EditRestaurantFragment extends BaseFragment implements EditRestaurantMvpView {
    public static final String TAG = EditRestaurantFragment.class.toString();
    private String restaurantId;

    @Inject
    EditRestaurantMvpPresenter<EditRestaurantMvpView> presenter;

    @BindView(R.id.et_restaurant_form_name)
    TextInputEditText restaurantName;

    @BindView(R.id.et_restaurant_form_phone_number)
    TextInputEditText restaurantPhoneNumber;

    @BindView(R.id.et_restaurant_form_delivery_cost)
    TextInputEditText restaurantDeliveryCost;

    @BindView(R.id.et_restaurant_form_min_order_cost)
    TextInputEditText restaurantMinOrderCost;

    @BindView(R.id.et_restaurant_form_max_paid_order_value)
    TextInputEditText restaurantMaxPaidOrderValue;

    @BindView(R.id.cb_restaurant_form_is_pyszne)
    CheckBox restaurantIsPyszne;

    public static EditRestaurantFragment newInstance() {
        Bundle args = new Bundle();
        EditRestaurantFragment fragment = new EditRestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_restaurant, container, false);
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
        bindRestaurant();
    }

    private void bindRestaurant() {
        Bundle bundle = getArguments();
        presenter.bindRestaurant(bundle);
    }

    @Override
    public void bindRestaurant(Restaurant restaurant) {
        restaurantId = restaurant.getId();
        restaurantName.setText(restaurant.getName());
        restaurantPhoneNumber.setText(restaurant.getPhoneNumber());
        String minOrderCost = BigDecimalFormatUtil.format(restaurant.getMinOrderCost());
        restaurantMinOrderCost.setText(minOrderCost != null ? minOrderCost : "");
        String deliveryCost = BigDecimalFormatUtil.format(restaurant.getDeliveryCost());
        restaurantDeliveryCost.setText(deliveryCost != null ? deliveryCost : "");
        String maxPaidOrderValue = BigDecimalFormatUtil.format(restaurant.getMaxPaidOrderValue());
        restaurantMaxPaidOrderValue.setText(maxPaidOrderValue != null ? maxPaidOrderValue : "");
        restaurantIsPyszne.setChecked(restaurant.isPyszne());
    }

    @OnClick(R.id.btn_edit_restaurant_go_back)
    @Override
    public void goBack() {
        requireFragmentManager().popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_edit_restaurant_save)
    void editRestaurant() {
        String name = ViewValueUtil.getValue(restaurantName);
        String phoneNumber = ViewValueUtil.getValue(restaurantPhoneNumber);
        String minOrderCost = ViewValueUtil.getValue(restaurantMinOrderCost);
        String deliveryCost = ViewValueUtil.getValue(restaurantDeliveryCost);
        String maxPaidOrderValue = ViewValueUtil.getValue(restaurantMaxPaidOrderValue);
        boolean isPyszne = restaurantIsPyszne.isChecked();
        presenter.editRestaurant(restaurantId, name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);
    }
}
