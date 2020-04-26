package com.example.sugandhkumar.payme;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {
    private EditText email;
    Button submit,btnBack;
    static String getemail;
    FirebaseAuth auth;
    private ProgressBar progressBar;
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-\\+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        email=findViewById(R.id.editText6);
        submit= (Button) findViewById(R.id.submit_area);
        btnBack= (Button) findViewById(R.id.btn_back);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getemail=email.getText().toString().trim();
                if (!TextUtils.isEmpty(getemail)){
                   //validateMail(getemail);
                    progressBar.setVisibility(View.VISIBLE);
                    auth.sendPasswordResetEmail(getemail)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ForgotPassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ForgotPassword.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }

                                    progressBar.setVisibility(View.GONE);
                                }
                            });

                } else {
                    Toast.makeText(getApplicationContext(), "Enter the Email", Toast.LENGTH_LONG).show();
                }

            }

        });
    }

    private static boolean validateMail(String getemail) {

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(getemail);
        return matcher.find();
    }


}
