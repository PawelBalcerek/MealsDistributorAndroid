package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.rest.AccountRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;

@Singleton
public class AccountWrapperService implements AccountService {
    private final AccountRestService accountRestService;
    private final ResponseWrapper responseWrapper;

    @Inject
    AccountWrapperService(AccountRestService accountRestService,
                          ResponseWrapper responseWrapper) {
        this.accountRestService = accountRestService;
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void login(Login body, CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(accountRestService.login(body))
                .subscribe(observer);
    }

    @Override
    public void logout(CustomCompletableObserver observer) {
        responseWrapper.wrapCompletable(accountRestService.logout())
                .subscribe(observer);
    }
}
