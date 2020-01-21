package pl.pawbal.mealsdistributor.data.models.dto.factory;

import org.junit.jupiter.api.Test;

import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountFactoryTest {
    private final AccountFactory accountFactory = new AccountFactory();

    @Test
    void createLogin() {
        //given
        String email = "email";
        String password = "password";

        //when
        Login result = accountFactory.create(email, password);

        //then
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
    }
}