package pl.pawbal.mealsdistributor.models.dto.response.orderposition;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetOrderPositions {
    private List<GetOrderPosition> orderPositions = new ArrayList<>();
}
