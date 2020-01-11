package pl.pawbal.mealsdistributor.models.dto.request.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddUser extends User {
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("confirmPassword")
    private String confirmPassword;
}
