package pl.pawbal.mealsdistributor.models.dto.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;
import pl.pawbal.mealsdistributor.models.enums.UserRole;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetUser extends User {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("role")
    private UserRole role;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
}
