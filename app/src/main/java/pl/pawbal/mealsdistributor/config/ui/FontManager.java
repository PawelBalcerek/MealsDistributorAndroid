package pl.pawbal.mealsdistributor.config.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontManager {
    private static final String ROOT = "fonts/";
    public static final String FONTAWESOME_BRANDS = ROOT + "fa-brands-400.ttf";
    public static final String FONTAWESOME_REGULAR = ROOT + "fa-regular-400.ttf";
    public static final String FONTAWESOME_SOLID = ROOT + "fa-solid-900.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    public static void markAsIconContainer(View v, Typeface typeface) {
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                markAsIconContainer(child, typeface);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(typeface);
        }
    }
}
