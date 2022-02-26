package com.example.firstfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText get_email;
    Button send_link;
    String fetch_email;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();
        get_email=(EditText)findViewById(R.id.inputEmail_forgpt);
        send_link=(Button)findViewById(R.id.btn_login_forgot);

        send_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetch_email=get_email.getText().toString();
                if (TextUtils.isEmpty(fetch_email)) {
                    get_email.setError("Email is Required.");
                }

                mAuth.sendPasswordResetEmail(fetch_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            // if isSuccessful then done message will be shown
                            // and you can change the password
                            Toast.makeText(ForgotPassword.this,"Verification mail sent",Toast.LENGTH_LONG).show();
                            Toast.makeText(ForgotPassword.this,"Please check your registered email",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ForgotPassword.this, Login.class));

                        }
                        else {
                            Toast.makeText(ForgotPassword.this,"Error Occured",Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgotPassword.this,"Error Failed",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }
}