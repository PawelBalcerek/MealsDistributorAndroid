package pl.pawbal.mealsdistributor.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.factory.AccountFactory;
import pl.pawbal.mealsdistributor.data.models.dto.request.account.Login;
import pl.pawbal.mealsdistributor.data.api.service.AccountService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.AccountWrapperService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;

public class LoginActivity extends Activity {
    private AccountService accountService;
    private final AccountFactory accountFactory = new AccountFactory();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("TEST", "ON_CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);
        accountService = new AccountWrapperService(getApplicationContext());
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    void login() {
        Log.i("TEST", "LOGIN");
        String email = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Login body = accountFactory.create(email, password);
        accountService.login(body, new CustomSingleObserver<>(compositeDisposable, a -> Log.i("TEST", a.headers().toString()), t -> Log.i("TEST", "TEST", t)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
