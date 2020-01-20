package pl.pawbal.mealsdistributor.ui.register;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.data.api.service.UserService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.models.dto.factory.UserFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.user.RegisterUser;
import pl.pawbal.mealsdistributor.ui.action.error.UserErrorHandler;
import pl.pawbal.mealsdistributor.ui.action.success.UserSuccessHandler;
import pl.pawbal.mealsdistributor.ui.base.BasePresenter;

public class RegisterPresenter<V extends RegisterMvpView> extends BasePresenter<V> implements RegisterMvpPresenter<V> {
    private final UserService userService;
    private final UserFactory userFactory;
    private final UserSuccessHandler successHandler;
    private final UserErrorHandler errorHandler;

    @Inject
    public RegisterPresenter(CompositeDisposable compositeDisposable,
                             UserService userService,
                             UserFactory userFactory,
                             UserSuccessHandler successHandler,
                             UserErrorHandler errorHandler) {
        super(compositeDisposable);
        this.userService = userService;
        this.userFactory = userFactory;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void register(String email, String password, String confirmPassword) {
        RegisterUser body = userFactory.create(email, password, confirmPassword);
        userService.registerUser(body, new CustomSingleObserver<>(
                getCompositeDisposable(),
                v -> successHandler.onRegisterUserSuccess(getMvpView()),
                errorHandler::onRegisterUserError
        ));
    }
}
