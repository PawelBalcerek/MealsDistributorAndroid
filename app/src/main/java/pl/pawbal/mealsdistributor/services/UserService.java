package pl.pawbal.mealsdistributor.services;

import java.util.UUID;

import pl.pawbal.mealsdistributor.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface UserService {
    void getCurrentUser(CustomSingleObserver<GetUser> observer);

    void registerUser(RegisterUser body, CustomSingleObserver<Void> observer);

    void editCurrentUser(EditCurrentUser body, CustomSingleObserver<Void> observer);

    void getUser(UUID id, CustomSingleObserver<GetUser> observer);
}
