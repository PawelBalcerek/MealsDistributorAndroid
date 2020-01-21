package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.rest.UserRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.EditCurrentUser;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.data.models.dto.response.user.GetUser;

@Singleton
public class UserWrapperService implements UserService {
    private final UserRestService userRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    UserWrapperService(UserRestService userRestService, ResponseWrapper responseWrapper) {
        this.userRestService = userRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void getCurrentUser(CustomSingleObserver<GetUser> observer) {
        responseWrapper.wrapSingle(userRestService.getCurrentUser())
                .subscribe(observer);
    }

    @Override
    public void registerUser(RegisterUser body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(userRestService.registerUser(body))
                .subscribe(observer);
    }

    @Override
    public void editCurrentUser(EditCurrentUser body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(userRestService.editCurrentUser(body))
                .subscribe(observer);
    }

    @Override
    public void getUser(UUID id, CustomSingleObserver<GetUser> observer) {
        responseWrapper.wrapSingle(userRestService.getUser(id))
                .subscribe(observer);
    }
}
