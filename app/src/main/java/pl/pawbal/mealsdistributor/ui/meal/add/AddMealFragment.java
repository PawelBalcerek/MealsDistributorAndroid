package pl.pawbal.mealsdistributor.ui.meal.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.custom.CustomDatePickerBuilder;
import pl.pawbal.mealsdistributor.util.ViewValueUtil;

public class AddMealFragment extends BaseFragment implements AddMealMvpView {
    public static final String TAG = AddMealFragment.class.toString();
    private String restaurantId;

    @Inject
    AddMealMvpPresenter<AddMealMvpView> presenter;

    @Inject
    CustomDatePickerBuilder customDatePickerBuilder;

    @BindView(R.id.et_meal_form_name)
    TextInputEditText mealName;

    @BindView(R.id.et_meal_form_description)
    TextInputEditText mealDescription;

    @BindView(R.id.et_meal_form_price)
    TextInputEditText mealPrice;

    @BindView(R.id.et_meal_form_start_date)
    TextInputEditText mealStartDate;

    @BindView(R.id.et_meal_form_end_date)
    TextInputEditText mealEndDate;

    private MaterialDatePicker<Long> startDatePicker;
    private MaterialDatePicker<Long> endDatePicker;

    public static AddMealFragment newInstance() {
        Bundle args = new Bundle();
        AddMealFragment fragment = new AddMealFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_meal, container, false);
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
        setUpDatePickers();
        presenter.bindRestaurantId(getArguments());
    }

    private void setUpDatePickers() {
        setUpStartDatePicker();
        setUpEndDatePicker();
    }

    private void setUpStartDatePicker() {
        startDatePicker = customDatePickerBuilder.build();
        startDatePicker.addOnPositiveButtonClickListener(
                selection -> mealStartDate.setText(startDatePicker.getHeaderText())
        );
    }

    private void setUpEndDatePicker() {
        endDatePicker = customDatePickerBuilder.build();
        endDatePicker.addOnPositiveButtonClickListener(
                selection -> mealEndDate.setText(endDatePicker.getHeaderText())
        );
    }

    @Override
    public void bindRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @OnClick(R.id.et_meal_form_start_date)
    void openStartDatePicker() {
        startDatePicker.show(requireFragmentManager(), startDatePicker.getTag());
    }

    @OnClick(R.id.et_meal_form_end_date)
    void openEndDatePicker() {
        endDatePicker.show(requireFragmentManager(), startDatePicker.getTag());
    }

    @OnClick(R.id.btn_add_meal_go_back)
    public void goBack() {
        requireFragmentManager().popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_add_meal_accept)
    public void saveMeal() {
        String name = ViewValueUtil.getValue(mealName);
        String description = ViewValueUtil.getValue(mealDescription);
        String price = ViewValueUtil.getValue(mealPrice);
        Long startDate = ViewValueUtil.getValue(mealStartDate, startDatePicker);
        Long endDate = ViewValueUtil.getValue(mealEndDate, endDatePicker);
        presenter.addMeal(name, description, price, restaurantId, startDate, endDate);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
