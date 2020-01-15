package pl.pawbal.mealsdistributor.data.api.service;

import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import retrofit2.Response;

public interface AccountService {
    void login(Login body, CustomSingleObserver<Response<Void>> observer);

    void logout(CustomSingleObserver<Void> observer);
}
