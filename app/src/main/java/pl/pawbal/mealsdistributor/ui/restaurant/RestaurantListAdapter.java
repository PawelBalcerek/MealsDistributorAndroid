package pl.pawbal.mealsdistributor.ui.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView restaurantName;
        TextView restaurantPhoneNumber;
        TextView restaurantIsPyszne;

        RestaurantViewHolder(@NonNull View view) {
            super(view);
            restaurantName = view.findViewById(R.id.tv_restaurant_name);
            restaurantPhoneNumber = view.findViewById(R.id.tv_restaurant_phoneNumber);
            restaurantIsPyszne = view.findViewById(R.id.tv_restaurant_isPyszne);
        }

        void bindData(Restaurant restaurant) {
            restaurantName.setText(restaurant.getName());
            restaurantPhoneNumber.setText(restaurant.getPhoneNumber());
            if (!restaurant.isPyszne()) restaurantIsPyszne.setVisibility(View.INVISIBLE);
            else restaurantIsPyszne.setVisibility(View.VISIBLE);
        }
    }

    private List<Restaurant> restaurants;

    RestaurantListAdapter(List<Restaurant> restaurants) {
        this.restaurants = Collections.unmodifiableList(restaurants);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.bindData(restaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.restaurant_view_holder;
    }
}
