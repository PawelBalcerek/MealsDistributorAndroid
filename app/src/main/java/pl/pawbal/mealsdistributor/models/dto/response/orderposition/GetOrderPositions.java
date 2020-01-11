package pl.pawbal.mealsdistributor.models.dto.response.orderposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetOrderPositions {
    @Expose
    @SerializedName("orderPositions")
    private List<GetOrderPosition> orderPositions = new ArrayList<>();
}
