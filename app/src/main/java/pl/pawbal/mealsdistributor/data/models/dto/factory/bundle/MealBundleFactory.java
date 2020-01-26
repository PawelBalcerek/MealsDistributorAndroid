package pl.pawbal.mealsdistributor.data.models.dto.factory.bundle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;

import static pl.pawbal.mealsdistributor.util.gson.CustomGsonBuilder.gson;

public class MealBundleFactory {
    private static final String MEAL_ID_BUNDLE_KEY = "mealId";
    private static final String GET_MEAL_BUNDLE_KEY = "getMeal";

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

    public Bundle create(GetMeal meal) {
        Bundle bundle = new Bundle();
        bundle.putString(GET_MEAL_BUNDLE_KEY, gson().toJson(meal));
        return bundle;
    }

    @Nullable
    public GetMeal getMeal(Bundle bundle) {
        String getMealJson = null;
        if (bundle != null)
            getMealJson = bundle.getString(GET_MEAL_BUNDLE_KEY);
        return gson().fromJson(getMealJson, GetMeal.class);
    }
}
