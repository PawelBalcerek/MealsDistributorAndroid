package pl.pawbal.mealsdistributor.models.dto.response.orderproposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.dto.base.OrderProposition;
import pl.pawbal.mealsdistributor.models.dto.base.OrderPropositionPosition;
import pl.pawbal.mealsdistributor.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.models.dto.base.User;

@Data
public class GetOrderProposition {
    @Expose
    @SerializedName("orderProposition")
    private OrderProposition orderProposition;

    @Expose
    @SerializedName("creator")
    private User user;

    @Expose
    @SerializedName("restaurant")
    private Restaurant restaurant;

    @Expose
    @SerializedName("orderPropositionPositions")
    private List<OrderPropositionPosition> orderPropositionPositions;
}
