package pl.pawbal.mealsdistributor.models.dto.request.orderposition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.Data;

@Data
public class AddOrderPosition {
    @Expose
    @SerializedName("mealId")
    private UUID mealId;
}
