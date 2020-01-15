package pl.pawbal.mealsdistributor.data.models.dto.factory;

import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;

public class AccountFactory {
    public Login create(String email, String password) {
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        return login;
    }
}
