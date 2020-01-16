package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.rest.AccountRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import retrofit2.Response;

@Singleton
public class AccountWrapperService implements AccountService {
    private final AccountRestService accountRestService;
    private final SingleWrapper singleWrapper;

    @Inject
    AccountWrapperService(AccountRestService accountRestService,
                          SingleWrapper singleWrapper) {
        this.accountRestService = accountRestService;
        this.singleWrapper = singleWrapper;
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
