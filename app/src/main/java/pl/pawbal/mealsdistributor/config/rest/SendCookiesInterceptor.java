package pl.pawbal.mealsdistributor.config.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import pl.pawbal.mealsdistributor.data.preference.PreferenceHelper;

@Singleton
public class SendCookiesInterceptor implements Interceptor {
    private final PreferenceHelper preferenceHelper;

    @Inject
    SendCookiesInterceptor(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String cookie = preferenceHelper.getNetCoreCookie();
        if (cookie != null) builder.addHeader("Cookie", preferenceHelper.getNetCoreCookie());
        return chain.proceed(builder.build());
    }
}
