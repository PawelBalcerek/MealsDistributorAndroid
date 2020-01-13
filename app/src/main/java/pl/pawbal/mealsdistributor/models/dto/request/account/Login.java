package pl.pawbal.mealsdistributor.models.dto.request.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Login {
    @Expose
    @SerializedName("login")
    String email;

    @Expose
    @SerializedName("password")
    String password;
}
