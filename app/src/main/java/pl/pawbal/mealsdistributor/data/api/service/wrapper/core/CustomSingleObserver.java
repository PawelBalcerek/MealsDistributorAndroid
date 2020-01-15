package pl.pawbal.mealsdistributor.data.api.service.wrapper.core;

import java.util.function.Consumer;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class CustomSingleObserver<T> implements SingleObserver<T> {
    private final CompositeDisposable compositeDisposable;
    private final Consumer<T> onSuccess;
    private final Consumer<Throwable> onError;

    public CustomSingleObserver(CompositeDisposable compositeDisposable,
                                Consumer<T> onSuccess,
                                Consumer<Throwable> onError) {
        this.compositeDisposable = compositeDisposable;
        this.onSuccess = onSuccess;
        this.onError = onError;
    }

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onSuccess(T t) {
        onSuccess.accept(t);
    }

    @Override
    public void onError(Throwable e) {
        onError.accept(e);
    }
}
