package pl.pawbal.mealsdistributor.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginMvpView {
    @Inject
    LoginMvpPresenter<LoginMvpView> presenter;

    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }

    @Override
    protected void setUp() {
        setContentView(R.layout.acitivity_login);
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
    }

    @OnClick(R.id.loginButton)
    void login() {
        String email = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        presenter.loginClick(email, password);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
