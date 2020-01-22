package pl.pawbal.mealsdistributor.util;

import android.text.Editable;
import android.widget.EditText;

public class EditTextUtil {
    public static String getValue(EditText editText) {
        Editable editable = editText.getText();
        return editable != null ? editable.toString() : null;
    }
}
