package pl.pawbal.mealsdistributor.ui.restaurant.add;

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
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.util.ViewValueUtil;

public class AddRestaurantFragment extends BaseFragment implements AddRestaurantMvpView {
    public static final String TAG = AddRestaurantFragment.class.toString();

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

    @Inject
    AddRestaurantMvpPresenter<AddRestaurantMvpView> presenter;

    public static AddRestaurantFragment newInstance() {
        Bundle args = new Bundle();
        AddRestaurantFragment fragment = new AddRestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_restaurant, container, false);
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
    }

    @OnClick(R.id.btn_add_restaurant_go_back)
    public void goBack() {
        requireFragmentManager().popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_add_restaurant_accept)
    void saveRestaurant() {
        String name = ViewValueUtil.getValue(restaurantName);
        String phoneNumber = ViewValueUtil.getValue(restaurantPhoneNumber);
        String minOrderCost = ViewValueUtil.getValue(restaurantMinOrderCost);
        String deliveryCost = ViewValueUtil.getValue(restaurantDeliveryCost);
        String maxPaidOrderValue = ViewValueUtil.getValue(restaurantMaxPaidOrderValue);
        boolean isPyszne = restaurantIsPyszne.isChecked();
        presenter.addRestaurant(name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);
    }

    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }
}
