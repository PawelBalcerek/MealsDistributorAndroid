package pl.pawbal.mealsdistributor.services;

import pl.pawbal.mealsdistributor.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface AccountService {
    void login(Login body, CustomSingleObserver<Void> observer);

    void logout(CustomSingleObserver<Void> observer);
}
