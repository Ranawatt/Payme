package com.example.sugandhkumar.payme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initViews();

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.custom_anim);
        imageView.startAnimation(animation);
        new Thread(new Runnable() {

            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void initViews() {
        textView= (TextView) findViewById(R.id.textView8);
        imageView= (ImageView) findViewById(R.id.imageView4);
        progressBar= (ProgressBar) findViewById(R.id.progressBar2);
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

    private void startApp() {

        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        intent.addFlags(IntentCompat.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
