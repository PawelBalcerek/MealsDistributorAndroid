package pl.pawbal.mealsdistributor.data.models.dto.request.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RegisterUser {
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("confirmPassword")
    private String confirmPassword;
}
