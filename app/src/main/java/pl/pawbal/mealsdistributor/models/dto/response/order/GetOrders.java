package pl.pawbal.mealsdistributor.models.dto.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetOrders {
    @Expose
    @SerializedName("orders")
    private List<GetOrder> orders = new ArrayList<>();
}
