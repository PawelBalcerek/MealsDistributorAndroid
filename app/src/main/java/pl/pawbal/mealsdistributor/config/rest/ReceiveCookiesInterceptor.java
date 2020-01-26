package pl.pawbal.mealsdistributor.config.rest;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Response;
import pl.pawbal.mealsdistributor.data.preference.PreferenceHelper;

@Singleton
public class ReceiveCookiesInterceptor implements Interceptor {
    private final PreferenceHelper preferenceHelper;

    @Inject
    ReceiveCookiesInterceptor(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        List<String> setCookieHeaders = originalResponse.headers("Set-Cookie");
        if (!setCookieHeaders.isEmpty()) {
            preferenceHelper.setNetCoreCookie(setCookieHeaders.toString());
        }
        return originalResponse;
    }
}
