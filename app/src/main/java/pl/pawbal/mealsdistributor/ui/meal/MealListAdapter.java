package pl.pawbal.mealsdistributor.ui.meal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Meal;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MealViewHolder> {
    static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView mealId;
        TextView mealName;
        TextView mealPrice;

        MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealId = itemView.findViewById(R.id.tv_meal_id);
            mealName = itemView.findViewById(R.id.tv_meal_name);
            mealPrice = itemView.findViewById(R.id.tv_meal_price);
        }

        void bindData(Meal meal) {
            mealId.setText(meal.getId());
            mealName.setText(meal.getName());
            mealPrice.setText(BigDecimalFormatUtil.formatWithCurrency(meal.getPrice()));
        }

        void bindClickListener(View.OnClickListener clickListener) {
            itemView.setOnClickListener(clickListener);
        }
    }

    private List<Meal> meals;
    private View.OnClickListener clickListener;

    MealListAdapter(List<Meal> meals, View.OnClickListener clickListener) {
        this.meals = Collections.unmodifiableList(meals);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        holder.bindData(meals.get(position));
        holder.bindClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.view_holder_meal;
    }
}
