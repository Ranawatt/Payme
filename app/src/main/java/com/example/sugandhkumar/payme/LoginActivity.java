package com.example.sugandhkumar.payme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.VideoView;
import com.example.sugandhkumar.payme.activity.MainActivity;
import com.example.sugandhkumar.payme.databinding.ActivityLoginBinding;
import com.facebook.CallbackManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    final Context context = this;
    private FirebaseAuth auth;
    private VideoView videoview;
    private Animation imgAnimation;
    boolean visible;
    CallbackManager callbackManager;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
//        FacebookSdk.sdkInitialize(getApplicationContext());
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        videoview = binding.included.findViewById(R.id.video_view);
        if (!isNetworkAvailable(this)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Are you offline?");
            alertDialogBuilder
                    .setMessage("Couldn't connect to the internet.Connect to the mobile data or WiFi and try again")
                    .setCancelable(false)
                    .setNegativeButton("TRY AGAIN", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent dialogIntent = new Intent(Settings.ACTION_SETTINGS);
                            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(dialogIntent);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        binding.btnLogin.setOnClickListener(this);
        binding.btnSignup.setOnClickListener(this);
        binding.btnResetPassword.setOnClickListener(this);
        binding.signInButton.setOnClickListener(this);
        binding.signUpButton.setOnClickListener(this);
        binding.btnBack.setOnClickListener(this);
        binding.btnForgot.setOnClickListener(this);

        imgAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fromtop);
        binding.imgIcon.setAnimation(imgAnimation);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anna_moskal);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(mediaPlayer ->
                mediaPlayer.setLooping(true)
        );
        binding.welcomeTxt.setTypeface(Typeface.createFromAsset(context.getAssets(), "Pangram-Regular.otf"));
        binding.forgotTxt.setTypeface(Typeface.createFromAsset(context.getAssets(), "Pangram-Medium.otf"));
        binding.welcomeSbtxt.setTypeface(Typeface.createFromAsset(context.getAssets(), "Pangram-Light.otf"));
        binding.forgotSbtxt.setTypeface(Typeface.createFromAsset(context.getAssets(), "Clockopia.ttf"));
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected())
            return true;
        else
            return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_signup) {
            binding.llSignin.setVisibility(View.GONE);
            binding.welcomeTxt.setText(getString(R.string.disc_trends));
            binding.welcomeSbtxt.setText(getString(R.string.signup_msg));
            binding.llSignup.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.btn_reset_password) {
            binding.llLogin.setVisibility(View.INVISIBLE);
            binding.llForgot.setVisibility(View.VISIBLE);
            binding.llForgotMsg.setAnimation(imgAnimation);
        } else if (view.getId() == R.id.btn_login) {
            signIn();
        } else if (view.getId() == R.id.sign_in_button) {
            binding.llSignup.setVisibility(View.INVISIBLE);
            binding.welcomeTxt.setText(getString(R.string.welcome));
            binding.welcomeSbtxt.setText(getString(R.string.welcome_note));
            binding.llSignin.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.btn_back) {
            binding.llForgot.setVisibility(View.INVISIBLE);
            binding.llLogin.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.sign_up_button) {
            signUp();
        } else if (view.getId() == R.id.btn_forgot) {
            forgotPwd();
        }
    }

    private void forgotPwd() {
        if (!TextUtils.isEmpty(binding.fgtEmail.getText().toString().trim())) {
            //validateMail(getemail);
            binding.progressBar.setVisibility(View.VISIBLE);
            auth.sendPasswordResetEmail(binding.fgtEmail.getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                TransitionManager.beginDelayedTransition(binding.transitionsContainer);
                                visible = !visible;
                                binding.forgotSbmsg.setTypeface(Typeface.createFromAsset(context.getAssets(), "Pangram-ExtraLight.otf"));
                                binding.forgotSbmsg.setTranslationX(View.AUTOFILL_TYPE_TOGGLE);
                                binding.forgotSbmsg.setVisibility(visible ? View.VISIBLE : View.GONE);
                            } else {
                                Toast.makeText(LoginActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                            }
                            binding.progressBar.setVisibility(View.GONE);
                        }
                    });
        } else
            Toast.makeText(getApplicationContext(), "Enter the Email", Toast.LENGTH_LONG).show();
    }

    private void signUp() {
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        binding.progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        binding.progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }

    private void signIn() {
        binding.email.requestFocus();
        String email = binding.email.getText().toString();
        binding.password.requestFocus();
        final String password = binding.password.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }
        binding.progressBar.setVisibility(View.VISIBLE);
        //authenticate user
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                binding.progressBar.setVisibility(View.GONE);
                if (!task.isSuccessful()) {
                    if (password.length() < 6)
                        binding.password.setError(getString(R.string.minimum_password));
                    else
                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}