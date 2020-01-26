package pl.pawbal.mealsdistributor.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.pawbal.mealsdistributor.di.ApplicationContext;
import pl.pawbal.mealsdistributor.di.PreferenceInfo;

@Singleton
public class AppPreferenceHelper implements PreferenceHelper {
    public static final String APP_PREFERENCE_FILE_NAME = "meal_distributor_pref";
    private static final String ASP_NET_CORE_COOKIE_PREFERENCE_KEY = "ASP_NET_CORE_COOKIE";

    private final SharedPreferences sharedPreferences;

    @Inject
    AppPreferenceHelper(@ApplicationContext Context context,
                        @PreferenceInfo String preferenceFileName) {
        this.sharedPreferences = context.getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE);
    }

    @Override
    @Nullable
    public String getNetCoreCookie() {
        return sharedPreferences.getString(ASP_NET_CORE_COOKIE_PREFERENCE_KEY, null);
    }

    @Override
    public void setNetCoreCookie(String netCoreCookie) {
        sharedPreferences.edit().putString(ASP_NET_CORE_COOKIE_PREFERENCE_KEY, netCoreCookie).apply();
    }
}
