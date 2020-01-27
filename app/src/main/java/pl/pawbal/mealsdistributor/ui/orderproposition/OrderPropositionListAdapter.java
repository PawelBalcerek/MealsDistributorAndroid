package pl.pawbal.mealsdistributor.ui.orderproposition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.OrderProposition;
import pl.pawbal.mealsdistributor.util.LocalTimeUtil;

public class OrderPropositionListAdapter extends RecyclerView.Adapter<OrderPropositionListAdapter.OrderPropositionViewHolder> {
    static class OrderPropositionViewHolder extends RecyclerView.ViewHolder {
        TextView orderPropositionId;
        TextView orderPropositionOrderTime;

        OrderPropositionViewHolder(@NonNull View view) {
            super(view);
            orderPropositionId = view.findViewById(R.id.tv_order_proposition_id);
            orderPropositionOrderTime = view.findViewById(R.id.tv_order_proposition_order_time);
        }

        void bindData(OrderProposition orderProposition) {
            String idAbbreviation = orderProposition.getId().split("-")[0] + "...";
            orderPropositionId.setText(idAbbreviation);
            int minute = orderProposition.getTimeToOrder().getMinute();
            int hour = orderProposition.getTimeToOrder().getHour();
            orderPropositionOrderTime.setText(LocalTimeUtil.format(hour, minute));
        }

        void bindClickListener(View.OnClickListener clickListener) {
            itemView.setOnClickListener(clickListener);
        }
    }

    private List<OrderProposition> orderPropositions;
    private View.OnClickListener onClickListener;

    public OrderPropositionListAdapter(List<OrderProposition> orderPropositions, View.OnClickListener onClickListener) {
        this.orderPropositions = Collections.unmodifiableList(orderPropositions);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public OrderPropositionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new OrderPropositionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderPropositionViewHolder holder, int position) {
        holder.bindData(orderPropositions.get(position));
        holder.bindClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return orderPropositions.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.view_holder_order_proposition;
    }
}
