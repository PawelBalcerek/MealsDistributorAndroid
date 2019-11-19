package pl.pawbal.mealsdistributor.models.dto.response.order;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetOrders {
    private List<GetOrder> orders = new ArrayList<>();
}
