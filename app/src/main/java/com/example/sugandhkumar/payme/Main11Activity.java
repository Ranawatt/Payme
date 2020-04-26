package com.example.sugandhkumar.payme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class Main11Activity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "Main11Activity.java";
    private EditText editText4,editText5;
    private TextView textView2;
    private Button button3;
    private LoginButton loginButton;
    CallbackManager callbackManager;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    Uri imageuri;
    AccessTokenTracker accessTokenTracker;
    ImageView iv_profile_pic;
    GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main11);
        editText4= (EditText) findViewById(R.id.editText4);
        editText5= (EditText) findViewById(R.id.editText5);
        textView2= (TextView) findViewById(R.id.textView2);
        button3= (Button) findViewById(R.id.button3);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        iv_profile_pic = (ImageView) findViewById(R.id.iv_profile_pic);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
        callbackManager = CallbackManager.Factory.create();
        auth = FirebaseAuth.getInstance();
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main11Activity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=editText4.getText().toString().trim();
                final String password=editText5.getText().toString().trim();

                if (!TextUtils.isEmpty(email)) {
                    if (isEmailValid(email)) {
                        if (!TextUtils.isEmpty(password)) {
                            if (isPasswordValid(password)) {
                                progressBar.setVisibility(View.VISIBLE);
                                //authenticate user
                                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Main11Activity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        // If sign in fails, display a message to the user. If sign in succeeds
                                        // the auth state listener will be notified and logic to handle the
                                        // signed in user can be handled in the listener.
                                        // progressBar.setVisibility(View.GONE);
                                        progressBar.setVisibility(View.GONE);
                                        if (!task.isSuccessful()) {
                                            // there was an error
                                                Toast.makeText(Main11Activity.this, "Authentication Failed", Toast.LENGTH_LONG).show();
                                        } else {
                                            Intent intent = new Intent(Main11Activity.this, HotelRestra.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });

                            } else {
                                editText5.setError(getString(R.string.error_invalid_password));
                            }
                        } else {
                            editText5.setError(getString(R.string.error_field_required));
                        }
                    }else{
                        editText4.setError(getString(R.string.error_invalid_email));
                    }
                }else {
                    editText4.setError(getString(R.string.error_field_required));
                }
                //Toast.makeText(Main11Activity.this,"WELCOME TO THW WORLD OF ANDROID",Toast.LENGTH_LONG).show();
            }
        });
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                iv_profile_pic = (ImageView) findViewById(R.id.iv_profile_pic);

                                loginButton = (LoginButton) findViewById(R.id.login_button);
                                loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
                                callbackManager = CallbackManager.Factory.create();
                                try {
                                    String email = object.getString("email");
                                    String birthday = object.getString("birthday");
                                    String id = object.getString("id");
                                    String name = object.getString("name");


                                    String imageurl = "https://graph.facebook.com/" + id + "/picture?type=large";

                                    Glide.with(Main11Activity.this).load(imageurl).into(iv_profile_pic);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
/**
 * AccessTokenTracker to manage logout
 * */
                accessTokenTracker = new AccessTokenTracker() {
                    @Override
                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                               AccessToken currentAccessToken) {
                        if (currentAccessToken == null) {
                            iv_profile_pic.setImageResource(R.drawable.belize);
                        }
                    }
                };
            }

            @Override
            public void onCancel() {}

            @Override
            public void onError(FacebookException error) {}
        });
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }
    private boolean isEmailValid(String email) {

        return email.contains("@gmail.com");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 6;
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sign_in_button:

                signIn();

                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Intent intent2=new Intent(Main11Activity.this,Main2Activity.class);
        startActivity(intent2);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
            Intent intent=new Intent(Main11Activity.this,Main3Activity.class);
            startActivity(intent);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

        } else {
            // Signed out, show unauthenticated UI.
            // updateUI(false);
        }
    }
}
