package pl.pawbal.mealsdistributor.data.models.dto.factory.bundle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

public class MealBundleFactory {
    private static final String MEAL_ID_BUNDLE_KEY = "mealId";

    @Inject
    public MealBundleFactory() {
    }

    public Bundle create(String mealId) {
        Bundle bundle = new Bundle();
        bundle.putString(MEAL_ID_BUNDLE_KEY, mealId);
        return bundle;
    }

    @Nullable
    public String getMealId(@Nullable Bundle bundle) {
        return bundle != null ? bundle.getString(MEAL_ID_BUNDLE_KEY) : null;
    }
}
