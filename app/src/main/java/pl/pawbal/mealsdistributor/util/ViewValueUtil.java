package pl.pawbal.mealsdistributor.util;

import android.text.Editable;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;

public class ViewValueUtil {
    public static String getValue(EditText editText) {
        Editable editable = editText.getText();
        return editable != null ? editable.toString() : null;
    }

    public static Long getValue(EditText editText, MaterialDatePicker<Long> datePicker) {
        Editable editable = editText.getText();
        if (editable == null) return null;
        try {
            return datePicker.getSelection();
        } catch (NullPointerException npe) {
            return LocalDateTimeUtil.getMilliSec(editable.toString());
        }
    }
}
