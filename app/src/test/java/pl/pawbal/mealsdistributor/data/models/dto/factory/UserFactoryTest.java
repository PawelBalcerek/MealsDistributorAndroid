package pl.pawbal.mealsdistributor.data.models.dto.factory;

import org.junit.jupiter.api.Test;

import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserFactoryTest {
    private final UserFactory userFactory = new UserFactory();

    @Test
    void createRegisterUser() {
        //given
        String email = "email";
        String password = "password";
        String confirmPassword = "confirmPassword";

        //when
        RegisterUser result = userFactory.create(email, password, confirmPassword);

        //then
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
        assertEquals(confirmPassword, result.getConfirmPassword());
    }
}