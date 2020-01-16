package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.rest.UserRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;

@Singleton
public class UserWrapperService implements UserService {
    private final UserRestService userRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    UserWrapperService(UserRestService userRestService, SingleWrapper singleWrapper) {
        this.userRestService = userRestService;
        this.singleWrapper = singleWrapper;
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
