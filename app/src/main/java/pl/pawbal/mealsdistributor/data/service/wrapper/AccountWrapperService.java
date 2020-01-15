package pl.pawbal.mealsdistributor.data.service.wrapper;

import android.content.Context;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.data.service.AccountService;
import pl.pawbal.mealsdistributor.data.service.rest.AccountRestService;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.SingleWrapper;
import retrofit2.Response;

public class AccountWrapperService implements AccountService {
    private final AccountRestService accountRestService;
    private final SingleWrapper singleWrapper;

    @SuppressWarnings("WeakerAccess")
    AccountWrapperService(AccountRestService accountRestService,
                          SingleWrapper singleWrapper) {
        this.accountRestService = accountRestService;
        this.singleWrapper = singleWrapper;
    }

    public AccountWrapperService(Context context) {
        this((new RestConfiguration(context)).create()
                .create(AccountRestService.class), SingleWrapper.singleWrapper());
    }

    @Override
    public void login(Login body, CustomSingleObserver<Response<Void>> observer) {
        Single<Response<Void>> single = accountRestService.login(body);
        singleWrapper.wrapSingle(single)
                .subscribe(observer);
    }

    @Override
    public void logout(CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(accountRestService.logout())
                .subscribe(observer);
    }
}
