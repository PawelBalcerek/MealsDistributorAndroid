package pl.pawbal.mealsdistributor.ui.custom;

import com.google.android.material.datepicker.MaterialDatePicker;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.R;

public class CustomDatePickerBuilder {
    @Inject
    public CustomDatePickerBuilder() {
    }

    public MaterialDatePicker<Long> build() {
        return MaterialDatePicker.Builder.datePicker()
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setTitleText(R.string.date_picker_title)
                .build();
    }
}
