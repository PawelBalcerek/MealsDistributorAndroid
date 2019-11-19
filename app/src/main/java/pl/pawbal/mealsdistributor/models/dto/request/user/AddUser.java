package pl.pawbal.mealsdistributor.models.dto.request.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddUser extends User {
    private String confirmPassword;
}
