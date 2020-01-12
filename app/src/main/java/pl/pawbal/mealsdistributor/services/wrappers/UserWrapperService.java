package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.user.EditUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.LoginUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.services.UserService;
import pl.pawbal.mealsdistributor.services.rest.UserRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

public class UserWrapperService implements UserService {
    private final UserRestService userRestService;

    @SuppressWarnings("WeakerAccess")
    UserWrapperService(UserRestService userRestService) {
        this.userRestService = userRestService;
    }

    public UserWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(UserRestService.class));
    }

    @Override
    public void getCurrentUserInfo(CustomSingleObserver<GetUser> observer) {
        userRestService.getCurrentUserInfo()
                .subscribe(observer);
    }

    @Override
    public void registerUser(RegisterUser user, CustomSingleObserver<Void> observer) {
        userRestService.registerUser(user)
                .subscribe(observer);
    }

    @Override
    public void loginUser(LoginUser user, CustomSingleObserver<Void> observer) {
        userRestService.loginUser(user)
                .subscribe(observer);
    }

    @Override
    public void editCurrentUserInfo(EditUser user, CustomSingleObserver<Void> observer) {
        userRestService.editCurrentUserInfo(user)
                .subscribe(observer);
    }
}
