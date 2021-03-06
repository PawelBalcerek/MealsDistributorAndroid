package pl.pawbal.mealsdistributor.data.models.dto.factory.bundle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;

public class RestaurantBundleFactory {
    private static final String RESTAURANT_ID_BUNDLE_KEY = "restaurantId";
    private static final String RESTAURANT_BUNDLE_KEY = "restaurant";

    @Inject
    public RestaurantBundleFactory() {
    }

    public Bundle create(String restaurantId) {
        Bundle bundle = new Bundle();
        bundle.putString(RESTAURANT_ID_BUNDLE_KEY, restaurantId);
        return bundle;
    }

    @Nullable
    public String getRestaurantId(@Nullable Bundle bundle) {
        return bundle != null ? bundle.getString(RESTAURANT_ID_BUNDLE_KEY) : null;
    }

    public Bundle create(Restaurant restaurant) {
        Bundle bundle = new Bundle();
        bundle.putString(RESTAURANT_BUNDLE_KEY, new Gson().toJson(restaurant));
        return bundle;
    }

    @Nullable
    public Restaurant restaurant(@Nullable Bundle bundle) {
        String restaurantJson = null;
        if (bundle != null)
            restaurantJson = bundle.getString(RESTAURANT_BUNDLE_KEY);
        return new Gson().fromJson(restaurantJson, Restaurant.class);
    }
}
