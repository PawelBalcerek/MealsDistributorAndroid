package pl.pawbal.mealsdistributor.services.wrappers.core;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SingleWrapper {
    private static SingleWrapper singleWrapper = null;

    private SingleWrapper() {
    }

    public static SingleWrapper singleWrapper() {
        if (singleWrapper != null) singleWrapper = new SingleWrapper();
        return singleWrapper;
    }

    public <T> Single<T> wrapSingle(Single<T> single) {
        return single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
