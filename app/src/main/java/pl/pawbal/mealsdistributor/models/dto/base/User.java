package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class User {
    @Expose
    @SerializedName("email")
    private String email;
}
