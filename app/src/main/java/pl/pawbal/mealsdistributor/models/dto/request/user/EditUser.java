package pl.pawbal.mealsdistributor.models.dto.request.user;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditUser extends User {
    private UUID id;
    private String password;
    private String confirmPassword;
}
