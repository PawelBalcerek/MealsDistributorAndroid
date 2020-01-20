package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;

public interface UserService {
    void getCurrentUser(CustomSingleObserver<GetUser> observer);

    void registerUser(RegisterUser body, CustomSingleObserver<Void> observer);

    void editCurrentUser(EditCurrentUser body, CustomSingleObserver<Void> observer);

    void getUser(UUID id, CustomSingleObserver<GetUser> observer);
}
