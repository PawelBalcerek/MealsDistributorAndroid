package pl.pawbal.mealsdistributor.util;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pl.pawbal.mealsdistributor.R;

public class FragmentUtil {
    public static void navigateToFragment(@Nullable Bundle bundle, FragmentManager fragmentManager,
                                          @Nullable Fragment fromStack, Fragment newInstance, String fragmentTag) {
        if (fromStack != null) {
            if (bundle != null) fromStack.setArguments(bundle);
            replaceFragment(fragmentManager, fromStack, fragmentTag);
        } else {
            if (bundle != null) newInstance.setArguments(bundle);
            replaceFragment(fragmentManager, newInstance, fragmentTag);
        }
    }

    private static void replaceFragment(@NonNull FragmentManager fragmentManager, Fragment fragment, String fragmentTag) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_wrapper, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }
}
