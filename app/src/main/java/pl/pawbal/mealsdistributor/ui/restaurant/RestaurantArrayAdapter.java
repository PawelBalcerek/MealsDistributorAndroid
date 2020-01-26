package pl.pawbal.mealsdistributor.ui.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;

public class RestaurantArrayAdapter extends ArrayAdapter<Restaurant> {
    private List<Restaurant> restaurants;

    public RestaurantArrayAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);
        this.restaurants = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null)
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.default_dropdown_menu_item, parent, false);
        Restaurant restaurant = getItem(position);
        TextView value = itemView.findViewById(R.id.dropdown_menu_item_value);
        if (restaurant != null) value.setText(restaurant.getName());
        return itemView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new RestaurantFilter();
    }

    private class RestaurantFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            List<Restaurant> filteredRestaurants = new ArrayList<>();
            if (constraint != null) {
                for (Restaurant restaurant : restaurants) {
                    if (restaurant.getName().toLowerCase().contains(constraint.toString().toLowerCase()))
                        filteredRestaurants.add(restaurant);
                }
                filterResults.values = filteredRestaurants;
                filterResults.count = filteredRestaurants.size();
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            if (results != null && results.count > 0)
                addAll((ArrayList<Restaurant>) results.values);
            notifyDataSetChanged();
        }
    }
}
