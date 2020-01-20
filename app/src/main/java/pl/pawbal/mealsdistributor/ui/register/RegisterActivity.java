package pl.pawbal.mealsdistributor.ui.register;

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

public class RegisterActivity extends BaseActivity implements RegisterMvpView {
    @Inject
    RegisterMvpPresenter<RegisterMvpView> presenter;

    @BindView(R.id.et_register_email)
    EditText emailEditText;

    @BindView(R.id.et_register_password)
    EditText passwordEditText;

    @BindView(R.id.et_register_confirmPassword)
    EditText confirmPasswordEditText;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }

    @Override
    protected void setUp() {
        setContentView(R.layout.activity_register);
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
    }

    @OnClick(R.id.btn_register_register)
    void register() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        presenter.register(email, password, confirmPassword);
    }

    @Override
    public void navigateToLogin() {
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
