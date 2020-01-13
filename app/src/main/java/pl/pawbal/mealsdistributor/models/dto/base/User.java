package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import pl.pawbal.mealsdistributor.models.enums.UserRole;

@Data
public class User {
    @Expose
    @SerializedName("id")
    private UUID id;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("role")
    private UserRole role;
    @Expose
    @SerializedName("creationDate")
    private LocalDateTime creationDate;
}
