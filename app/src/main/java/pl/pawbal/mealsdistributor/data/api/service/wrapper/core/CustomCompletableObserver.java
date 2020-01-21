package pl.pawbal.mealsdistributor.data.api.service.wrapper.core;

import java.util.function.Consumer;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class CustomCompletableObserver implements CompletableObserver {
    private final CompositeDisposable compositeDisposable;
    private final Action onComplete;
    private final Consumer<Throwable> onError;

    public CustomCompletableObserver(CompositeDisposable compositeDisposable,
                                     Action onComplete,
                                     Consumer<Throwable> onError) {
        this.compositeDisposable = compositeDisposable;
        this.onComplete = onComplete;
        this.onError = onError;
    }

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onComplete() {
        try {
            onComplete.run();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onError(Throwable e) {
        onError.accept(e);
    }
}
