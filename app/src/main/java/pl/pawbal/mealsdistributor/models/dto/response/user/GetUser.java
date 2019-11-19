package pl.pawbal.mealsdistributor.models.dto.response.user;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pawbal.mealsdistributor.models.dto.base.User;
import pl.pawbal.mealsdistributor.models.enums.UserRole;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetUser extends User {
    private UUID id;
    private UserRole role;
}
