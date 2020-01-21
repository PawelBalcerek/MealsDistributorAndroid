package pl.pawbal.mealsdistributor.data.api.service;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;

public interface AccountService {
    void login(Login body, CustomCompletableObserver observer);

    void logout(CustomCompletableObserver observer);
}
