package com.example.myapplicati.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.myapplicati.R;
import com.example.myapplicati.db.AppDatabase;
import com.example.myapplicati.db.AppPref;
import com.example.myapplicati.networking.model.AppConfig;
import com.example.myapplicati.networking.model.Product;
import com.example.myapplicati.ui.base.BaseActivity;
import com.example.myapplicati.ui.main.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        makeFullScreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        changeStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        hideToolbar();

        // checking for auth token in prefs
        if (TextUtils.isEmpty(AppPref.getInstance().getAuthToken())) {
            // user token is not present, take him to login screen
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }
        fetchAppConfig();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    /**
     * Fetching app configuration from server
     * This will get PayTM configuration required for payment related operations
     */
    private void fetchAppConfig() {
        Call<AppConfig> call = getApi().getAppConfig();
        call.enqueue(new Callback<AppConfig>() {
            @Override
            public void onResponse(Call<AppConfig> call, Response<AppConfig> response) {
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }

                // save app config to db
                AppDatabase.saveAppConfig(response.body());

                // fetch products
                fetchProducts();
            }

            @Override
            public void onFailure(Call<AppConfig> call, Throwable t) {
                handleError(t);
            }
        });
    }

    /**
     * Fetching products on splash screen before loading home screen
     */
    private void fetchProducts() {
        Call<List<Product>> call = getApi().getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }

                // store products in db
                AppDatabase.saveProducts(response.body());

                // start home screen
                launchHomeScreen();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                handleError(t);
            }
        });
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}