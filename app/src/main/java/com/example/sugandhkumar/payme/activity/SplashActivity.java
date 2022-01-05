package com.example.sugandhkumar.payme.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sugandhkumar.payme.LoginActivity;
import com.example.sugandhkumar.payme.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    ProgressBar progressBar;
    TextView textView;
    Animation animation, fromBottom;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViews();

        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.custom_anim);
        imageView.startAnimation(animation);

        fromBottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frombottom);
        textView.setAnimation(fromBottom);
        new Thread(new Runnable() {

            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void initViews() {
        textView= findViewById(R.id.textView8);
        imageView= findViewById(R.id.imageView4);
        progressBar=  findViewById(R.id.progressBar2);
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(200);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("WrongConstant")
    private void startApp() {

        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
