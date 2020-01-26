package pl.pawbal.mealsdistributor.ui.orderproposition.add;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.custom.CustomTimePickerBuilder;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantArrayAdapter;
import pl.pawbal.mealsdistributor.util.LocalTimeUtil;
import pl.pawbal.mealsdistributor.util.ViewValueUtil;

public class AddOrderPropositionFragment extends BaseFragment implements AddOrderPropositionMvpView {
    public static final String TAG = AddOrderPropositionFragment.class.toString();
    private Restaurant currentlySelected;

    @Inject
    AddOrderPropositionMvpPresenter<AddOrderPropositionMvpView> presenter;

    @Inject
    CustomTimePickerBuilder timePickerBuilder;

    @BindView(R.id.auto_order_proposition_form_restaurant)
    AutoCompleteTextView restaurantsAutoComplete;

    @BindView(R.id.et_order_proposition_form_order_time)
    TextInputEditText orderPropositionOrderTime;

    private TimePickerDialog timePickerDialog;

    public static AddOrderPropositionFragment newInstance() {
        Bundle args = new Bundle();
        AddOrderPropositionFragment fragment = new AddOrderPropositionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_order_proposition, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            if (view != null) ButterKnife.bind(this, view);
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        setUpTimePickerDialog();
        presenter.getRestaurants();
    }

    private void setUpTimePickerDialog() {
        timePickerDialog = timePickerBuilder.build(getContext(),
                (view, hourOfDay, minute) -> orderPropositionOrderTime.setText(LocalTimeUtil.format(hourOfDay, minute)));
    }

    @Override
    public void bindRestaurants(List<Restaurant> restaurants) {
        RestaurantArrayAdapter adapter = new RestaurantArrayAdapter(requireContext(), R.layout.default_dropdown_menu_item, restaurants);
        restaurantsAutoComplete.setAdapter(adapter);
        restaurantsAutoComplete.setOnItemClickListener((parent, view, position, id) -> onRestaurantItemSelected(parent, position));
    }

    private void onRestaurantItemSelected(AdapterView<?> parent, int position) {
        Restaurant restaurant = (Restaurant) parent.getItemAtPosition(position);
        restaurantsAutoComplete.setText(restaurant.getName());
        currentlySelected = restaurant;
    }

    @OnClick(R.id.et_order_proposition_form_order_time)
    void openTimePicker() {
        timePickerDialog.show();
    }

    @Override
    @OnClick(R.id.btn_add_order_proposition_go_back)
    public void goBack() {
        requireFragmentManager().popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_add_order_proposition_accept)
    public void addOrderProposition() {
        String restaurantId = currentlySelected.getId();
        Long orderTime = LocalTimeUtil.getMilliSec(ViewValueUtil.getValue(orderPropositionOrderTime));
        presenter.addOrderProposition(restaurantId, orderTime);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
