package pl.pawbal.mealsdistributor.data.models.dto.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.data.models.dto.base.Order;

@Data
public class GetOrders {
    @Expose
    @SerializedName("orders")
    private List<Order> orders = new ArrayList<>();
}
