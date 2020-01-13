package pl.pawbal.mealsdistributor.models.dto.response.orderpropositionposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.dto.base.OrderPosition;

@Data
public class GetOrderPropositionPositions {
    @Expose
    @SerializedName("orderPropositionPositions")
    private List<OrderPosition> orderPropositionPositions = new ArrayList<>();
}
