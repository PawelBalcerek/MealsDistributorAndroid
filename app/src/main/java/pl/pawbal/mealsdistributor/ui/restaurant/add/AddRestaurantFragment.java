package pl.pawbal.mealsdistributor.ui.restaurant.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.util.EditTextUtil;

public class AddRestaurantFragment extends BaseFragment implements AddRestaurantMvpView {
    public static final String TAG = AddRestaurantFragment.class.toString();

    @BindView(R.id.et_add_restaurant_name)
    TextInputEditText restaurantName;

    @BindView(R.id.et_add_restaurant_phoneNumber)
    TextInputEditText restaurantPhoneNumber;

    @BindView(R.id.et_add_restaurant_deliveryCost)
    TextInputEditText restaurantDeliveryCost;

    @BindView(R.id.et_add_restaurant_minOrderCost)
    TextInputEditText restaurantMinOrderCost;

    @BindView(R.id.et_add_restaurant_maxPaidOrderValue)
    TextInputEditText restaurantMaxPaidOrderValue;

    @BindView(R.id.cb_add_restaurant_isPyszne)
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
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) fragmentManager.popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_add_restaurant_accept)
    public void saveRestaurant() {
        String name = EditTextUtil.getValue(restaurantName);
        String phoneNumber = EditTextUtil.getValue(restaurantPhoneNumber);
        String minOrderCost = EditTextUtil.getValue(restaurantMinOrderCost);
        String deliveryCost = EditTextUtil.getValue(restaurantDeliveryCost);
        String maxPaidOrderValue = EditTextUtil.getValue(restaurantMaxPaidOrderValue);
        boolean isPyszne = restaurantIsPyszne.isChecked();
        presenter.addRestaurant(name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);
    }

    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }
}
