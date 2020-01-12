package pl.pawbal.mealsdistributor.services;

import pl.pawbal.mealsdistributor.models.dto.request.user.EditUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.LoginUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public interface UserService {
    void getCurrentUserInfo(CustomSingleObserver<GetUser> observer);

    void registerUser(RegisterUser user, CustomSingleObserver<Void> observer);

    void loginUser(LoginUser user, CustomSingleObserver<Void> observer);

    void editCurrentUserInfo(EditUser user, CustomSingleObserver<Void> observer);
}
