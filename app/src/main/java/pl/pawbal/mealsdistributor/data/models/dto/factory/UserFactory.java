package pl.pawbal.mealsdistributor.data.models.dto.factory;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;

public class UserFactory {
    @Inject
    public UserFactory() {
    }

    public RegisterUser create(String email, String password, String confirmPassword) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(email);
        registerUser.setPassword(password);
        registerUser.setConfirmPassword(confirmPassword);
        return registerUser;
    }
}
