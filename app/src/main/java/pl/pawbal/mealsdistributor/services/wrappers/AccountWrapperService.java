package pl.pawbal.mealsdistributor.services.wrappers;

import android.content.Context;

import pl.pawbal.mealsdistributor.config.RestConfiguration;
import pl.pawbal.mealsdistributor.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.services.AccountService;
import pl.pawbal.mealsdistributor.services.rest.AccountRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

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
                .create(AccountRestService.class), new SingleWrapper());
    }

    @Override
    public void login(Login body, CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(accountRestService.login(body))
                .subscribe(observer);
    }

    @Override
    public void logout(CustomSingleObserver<Void> observer) {
        singleWrapper.wrapSingle(accountRestService.logout())
                .subscribe(observer);
    }
}
