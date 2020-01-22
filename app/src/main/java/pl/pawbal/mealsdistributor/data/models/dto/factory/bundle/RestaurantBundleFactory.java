package pl.pawbal.mealsdistributor.data.models.dto.factory.bundle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;

public class RestaurantBundleFactory {
    public Bundle create(GetRestaurant restaurant) {
        Bundle bundle = new Bundle();
        bundle.putString("getRestaurant", new Gson().toJson(restaurant));
        return bundle;
    }

    public GetRestaurant getRestaurant(@Nullable Bundle bundle) {
        String getRestaurantJson = null;
        if (bundle != null)
            getRestaurantJson = bundle.getString("getRestaurant");
        return new Gson().fromJson(getRestaurantJson, GetRestaurant.class);
    }
}
