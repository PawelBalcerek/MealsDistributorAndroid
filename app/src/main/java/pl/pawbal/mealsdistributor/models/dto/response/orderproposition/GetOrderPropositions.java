package pl.pawbal.mealsdistributor.models.dto.response.orderproposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.dto.base.OrderProposition;

@Data
class GetOrderPropositions {
    @Expose
    @SerializedName("orderPropositions")
    private List<OrderProposition> orderPropositions;
}
