package pl.pawbal.mealsdistributor.data.models.dto.response.orderposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.data.models.dto.base.OrderPosition;

@Data
public class GetOrderPositions {
    @Expose
    @SerializedName("orderPropositionPositions")
    private List<OrderPosition> orderPositions = new ArrayList<>();
}
