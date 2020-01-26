package pl.pawbal.mealsdistributor.ui.custom;

import android.app.TimePickerDialog;
import android.content.Context;
import android.text.format.DateFormat;

import java.util.Calendar;

import javax.inject.Inject;

public class CustomTimePickerBuilder {
    @Inject
    public CustomTimePickerBuilder() {
    }

    public TimePickerDialog build(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        Calendar calendar = Calendar.getInstance();
        return new TimePickerDialog(context,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(context));
    }
}
