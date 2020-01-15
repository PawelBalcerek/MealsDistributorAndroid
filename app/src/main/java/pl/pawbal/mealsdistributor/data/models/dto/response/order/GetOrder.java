package pl.pawbal.mealsdistributor.data.models.dto.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.data.models.dto.base.Order;
import pl.pawbal.mealsdistributor.data.models.dto.base.OrderPosition;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.base.User;

@Data
public class GetOrder {
    @Expose
    @SerializedName("order")
    Order order;
    @Expose
    @SerializedName("orderBoy")
    User user;
    @Expose
    @SerializedName("restaurant")
    Restaurant restaurant;
    @Expose
    @SerializedName("orderPositions")
    List<OrderPosition> orderPositions;
}
