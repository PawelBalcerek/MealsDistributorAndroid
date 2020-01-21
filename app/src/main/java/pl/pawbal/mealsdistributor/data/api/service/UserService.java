package pl.pawbal.mealsdistributor.data.api.service;

import java.util.UUID;

import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;

public interface UserService {
    void getCurrentUser(CustomSingleObserver<GetUser> observer);

    void registerUser(RegisterUser body, CustomCompletableObserver observer);

    void editCurrentUser(EditCurrentUser body, CustomCompletableObserver observer);

    void getUser(UUID id, CustomSingleObserver<GetUser> observer);
}
