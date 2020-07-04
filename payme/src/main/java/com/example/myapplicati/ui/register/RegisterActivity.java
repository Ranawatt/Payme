package com.example.myapplicati.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicati.R;
import com.example.myapplicati.db.AppDatabase;
import com.example.myapplicati.db.AppPref;
import com.example.myapplicati.db.model.User;
import com.example.myapplicati.networking.model.RegisterRequest;
import com.example.myapplicati.ui.base.BaseActivity;
import com.example.myapplicati.ui.login.LoginActivity;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.*;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.input_name)
    EditText inputName;

    @BindView(R.id.input_email)
    EditText inputEmail;

    @BindView(R.id.input_password)
    EditText inputPassword;

    @BindView(R.id.loader)
    AVLoadingIndicatorView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        changeStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        hideToolbar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.btn_register)
    void onRegisterClick() {
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (isEmpty(name) || isEmpty(email) || isEmpty(password)) {
            Toast.makeText(getApplicationContext(), getString(R.string.msg_fill_the_form), Toast.LENGTH_LONG).show();
            return;
        }

        loader.setVisibility(View.VISIBLE);
        RegisterRequest request = new RegisterRequest();
        request.name = name;
        request.email = email;
        request.password = password;
        request.confirmPassword = password;
        getApi().register(request).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loader.setVisibility(View.INVISIBLE);
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }

                AppDatabase.saveUser(response.body());
                AppPref.getInstance().saveAuthToken(response.body().token);
                launchSplash(RegisterActivity.this);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loader.setVisibility(View.INVISIBLE);
                handleError(t);
            }
        });
    }

    @OnClick(R.id.btn_login_account)
    void onCreateAccountClick() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}