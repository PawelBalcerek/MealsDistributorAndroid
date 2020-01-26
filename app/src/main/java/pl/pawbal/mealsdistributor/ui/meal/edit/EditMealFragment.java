package pl.pawbal.mealsdistributor.ui.meal.edit;

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
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.custom.CustomDatePickerBuilder;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeUtil;
import pl.pawbal.mealsdistributor.util.ViewValueUtil;

public class EditMealFragment extends BaseFragment implements EditMealMvpView {
    public static final String TAG = EditMealFragment.class.toString();
    private String mealId;

    @Inject
    EditMealMvpPresenter<EditMealMvpView> presenter;

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

    public static EditMealFragment newInstance() {
        Bundle args = new Bundle();
        EditMealFragment fragment = new EditMealFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_meal, container, false);
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
        presenter.bindMeal(getArguments());
    }

    @Override
    public void bindMeal(GetMeal meal) {
        mealId = meal.getId();
        mealName.setText(meal.getName());
        mealDescription.setText(meal.getDescription());
        mealPrice.setText(BigDecimalFormatUtil.format(meal.getPrice()));
        Long startDate = LocalDateTimeUtil.getMilliSec(meal.getStartDate());
        setUpStartDatePicker(startDate);
        mealStartDate.setText(LocalDateTimeUtil.format(meal.getStartDate()));
        Long endDate = LocalDateTimeUtil.getMilliSec(meal.getEndDate());
        setUpEndDatePicker(endDate);
        mealEndDate.setText(LocalDateTimeUtil.format(meal.getEndDate()));
    }

    private void setUpStartDatePicker(Long selection) {
        startDatePicker = selection != null ? customDatePickerBuilder.build(selection) : customDatePickerBuilder.build();
        startDatePicker.addOnPositiveButtonClickListener(
                ignored -> mealStartDate.setText(startDatePicker.getHeaderText())
        );
    }

    private void setUpEndDatePicker(Long selection) {
        endDatePicker = selection != null ? customDatePickerBuilder.build(selection) : customDatePickerBuilder.build();
        endDatePicker.addOnPositiveButtonClickListener(
                ignored -> mealEndDate.setText(endDatePicker.getHeaderText())
        );
    }

    @OnClick(R.id.et_meal_form_start_date)
    void openStartDatePicker() {
        startDatePicker.show(requireFragmentManager(), startDatePicker.getTag());
    }

    @OnClick(R.id.et_meal_form_end_date)
    void openEndDatePicker() {
        endDatePicker.show(requireFragmentManager(), startDatePicker.getTag());
    }

    @Override
    @OnClick(R.id.btn_edit_meal_go_back)
    public void goBack() {
        requireFragmentManager().popBackStack();
        hideKeyboard();
    }

    @OnClick(R.id.btn_edit_meal_save)
    public void saveMeal() {
        String id = mealId;
        String name = ViewValueUtil.getValue(mealName);
        String description = ViewValueUtil.getValue(mealDescription);
        String price = ViewValueUtil.getValue(mealPrice);
        Long startDate = ViewValueUtil.getValue(mealStartDate, startDatePicker);
        Long endDate = ViewValueUtil.getValue(mealEndDate, endDatePicker);
        presenter.saveMeal(id, name, description, price, startDate, endDate);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
