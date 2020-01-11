package pl.pawbal.mealsdistributor.models.dto.request.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditUser extends User {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("confirmPassword")
    private String confirmPassword;
}
