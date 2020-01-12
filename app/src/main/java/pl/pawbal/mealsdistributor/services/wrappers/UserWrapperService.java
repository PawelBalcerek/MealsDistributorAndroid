package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.services.UserService;
import pl.pawbal.mealsdistributor.services.rest.UserRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

public class UserWrapperService implements UserService {
    private final UserRestService userRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    UserWrapperService(UserRestService userRestService, SingleWrapper singleWrapper) {
        this.userRestService = userRestService;
        this.singleWrapper = singleWrapper;
    }

    public UserWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(UserRestService.class), new SingleWrapper());
    }

    @Override
    public void getCurrentUser(CustomSingleObserver<GetUser> observer) {
        singleWrapper.wrapSingle(userRestService.getCurrentUser())
                .subscribe(observer);
    }

    @Override
    public void registerUser(RegisterUser body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(userRestService.registerUser(body))
                .subscribe(observer);
    }

    @Override
    public void editCurrentUser(EditCurrentUser body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(userRestService.editCurrentUser(body))
                .subscribe(observer);
    }
}