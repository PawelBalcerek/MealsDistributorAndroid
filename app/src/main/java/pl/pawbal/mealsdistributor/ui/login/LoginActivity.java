package pl.pawbal.mealsdistributor.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.ui.base.BaseActivity;
import pl.pawbal.mealsdistributor.ui.main.MainActivity;
import pl.pawbal.mealsdistributor.ui.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements LoginMvpView {
    @Inject
    LoginMvpPresenter<LoginMvpView> presenter;

    @BindView(R.id.et_login_login)
    EditText loginEditText;

    @BindView(R.id.et_login_password)
    EditText passwordEditText;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }

    @Override
    protected void setUp() {
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
    }

    @OnClick(R.id.btn_login_login)
    void login() {
        String email = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        presenter.loginClick(email, password);
    }

    @OnClick(R.id.tv_login_register)
    void navigateToRegister() {
        Intent intent = RegisterActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
