package com.example.sugandhkumar.payme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.sugandhkumar.payme.activity.MainActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    final Context context = this;
    private EditText inputEmail, inputPassword, fgtEmail, regEmail, regPwd;
    private ImageView imgLogo;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset, signinButton, signupButton, googleLogin, btnBack, btnForgot;
    private Button fbLogin;
    private VideoView videoview;
    private Animation imgAnimation;
    private LinearLayout llSignin, llSignup, llLogin, llForgot, llForgotMsg;
    private TextView welcome_txt, welcome_sbtxt, text, forgot_txt, forgot_sbtxt;
    ViewGroup transitionsContainer;
    boolean visible;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
//        FacebookSdk.sdkInitialize(getApplicationContext());
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initViews();
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

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        signinButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnForgot.setOnClickListener(this);

        imgAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fromtop);
        imgLogo.setAnimation(imgAnimation);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anna_moskal);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        welcome_txt.setTypeface(Typeface.createFromAsset(context.getAssets(),"Pangram-Regular.otf"));
        forgot_txt.setTypeface(Typeface.createFromAsset(context.getAssets(),"Pangram-Medium.otf"));
        welcome_sbtxt.setTypeface(Typeface.createFromAsset(context.getAssets(),"Pangram-Light.otf"));
        forgot_sbtxt.setTypeface(Typeface.createFromAsset(context.getAssets(),"Clockopia.ttf"));
    }

    private void initViews() {
        imgLogo = (ImageView) findViewById(R.id.img_icon);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        videoview = (VideoView) findViewById(R.id.video_view);
        fbLogin = (Button) findViewById(R.id.fb_login);
        googleLogin = (Button) findViewById(R.id.gle_login);
        welcome_txt = (TextView) findViewById(R.id.welcome_txt);
        welcome_sbtxt = (TextView) findViewById(R.id.welcome_sbtxt);
        llSignin = (LinearLayout) findViewById(R.id.llSignin);
        llSignup = (LinearLayout) findViewById(R.id.llSignup);
        llLogin = (LinearLayout) findViewById(R.id.llLogin);
        llForgot = (LinearLayout) findViewById(R.id.llForgot);
        llForgotMsg = (LinearLayout) findViewById(R.id.llForgot_msg);
        signinButton = (Button) findViewById(R.id.sign_in_button);
        signupButton = (Button) findViewById(R.id.sign_up_button);
        fgtEmail = (EditText) findViewById(R.id.fgt_email);
        regEmail = (EditText) findViewById(R.id.et_email);
        regPwd = (EditText) findViewById(R.id.et_password);
        btnBack = (Button) findViewById(R.id.btn_back);
        forgot_txt = (TextView) findViewById(R.id.forgot_txt);
        forgot_sbtxt = (TextView) findViewById(R.id.forgot_sbtxt);

        transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        text = (TextView) transitionsContainer.findViewById(R.id.forgot_sbmsg);
        btnForgot = (Button) transitionsContainer.findViewById(R.id.btn_forgot);
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
            llSignin.setVisibility(View.GONE);
            welcome_txt.setText(getString(R.string.disc_trends));
            welcome_sbtxt.setText(getString(R.string.signup_msg));
            llSignup.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.btn_reset_password) {
            llLogin.setVisibility(View.INVISIBLE);
            llForgot.setVisibility(View.VISIBLE);
            llForgotMsg.setAnimation(imgAnimation);
        } else if (view.getId() == R.id.btn_login) {
            signIn();
        }else if (view.getId() == R.id.sign_in_button){
            llSignup.setVisibility(View.INVISIBLE);
            welcome_txt.setText(getString(R.string.welcome));
            welcome_sbtxt.setText(getString(R.string.welcome_note));
            llSignin.setVisibility(View.VISIBLE);
        }else if (view.getId() == R.id.btn_back){
            llForgot.setVisibility(View.INVISIBLE);
            llLogin.setVisibility(View.VISIBLE);
        }else if (view.getId() == R.id.sign_up_button){
            signUp();
        }else if (view.getId() == R.id.btn_forgot){
            forgotPwd();
        }
    }

    private void forgotPwd() {
        if (!TextUtils.isEmpty(fgtEmail.getText().toString().trim())){
            //validateMail(getemail);
            progressBar.setVisibility(View.VISIBLE);
            auth.sendPasswordResetEmail(fgtEmail.getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                TransitionManager.beginDelayedTransition(transitionsContainer);
                                visible = !visible;
                                text.setTypeface(Typeface.createFromAsset(context.getAssets(),"Pangram-ExtraLight.otf"));
                                text.setTranslationX(View.AUTOFILL_TYPE_TOGGLE);
                                text.setVisibility(visible ? View.VISIBLE : View.GONE);
                            } else {
                                Toast.makeText(LoginActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });

        } else {
            Toast.makeText(getApplicationContext(), "Enter the Email", Toast.LENGTH_LONG).show();
        }
    }

    private void signUp() {
        String email = regEmail.getText().toString().trim();
        String password = regPwd.getText().toString().trim();

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

        progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
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
        inputEmail.requestFocus();
        String email = inputEmail.getText().toString();
        inputPassword.requestFocus();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        //authenticate user
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                progressBar.setVisibility(View.GONE);
                if (!task.isSuccessful()) {
                    if (password.length() < 6)
                        inputPassword.setError(getString(R.string.minimum_password));
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
