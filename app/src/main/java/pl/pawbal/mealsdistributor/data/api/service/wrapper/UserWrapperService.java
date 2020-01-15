package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import android.content.Context;

import java.util.UUID;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;
import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.rest.UserRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;

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
                .create(UserRestService.class), SingleWrapper.singleWrapper());
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

    @Override
    public void getUser(UUID id, CustomSingleObserver<GetUser> observer) {
        singleWrapper.wrapSingle(userRestService.getUser(id))
                .subscribe(observer);
    }
}
