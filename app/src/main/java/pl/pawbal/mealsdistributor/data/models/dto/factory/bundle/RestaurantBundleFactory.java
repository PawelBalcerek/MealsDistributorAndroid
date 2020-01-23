package pl.pawbal.mealsdistributor.data.models.dto.factory.bundle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;

public class RestaurantBundleFactory {
    private static final String GET_RESTAURANT_BUNDLE_KEY = "getRestaurant";
    private static final String RESTAURANT_BUNDLE_KEY = "restaurant";

    public Bundle create(GetRestaurant restaurant) {
        Bundle bundle = new Bundle();
        bundle.putString(GET_RESTAURANT_BUNDLE_KEY, new Gson().toJson(restaurant));
        return bundle;
    }

    public GetRestaurant getRestaurant(@Nullable Bundle bundle) {
        String getRestaurantJson = null;
        if (bundle != null)
            getRestaurantJson = bundle.getString(GET_RESTAURANT_BUNDLE_KEY);
        return new Gson().fromJson(getRestaurantJson, GetRestaurant.class);
    }

    public Bundle create(Restaurant restaurant) {
        Bundle bundle = new Bundle();
        bundle.putString(RESTAURANT_BUNDLE_KEY, new Gson().toJson(restaurant));
        return bundle;
    }

    public Restaurant restaurant(@Nullable Bundle bundle) {
        String restaurantJson = null;
        if (bundle != null)
            restaurantJson = bundle.getString(RESTAURANT_BUNDLE_KEY);
        return new Gson().fromJson(restaurantJson, Restaurant.class);
    }
}
