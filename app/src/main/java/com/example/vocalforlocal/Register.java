package com.example.vocalforlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText FullName , EmailID , Password , PhoneNo;
    Button RegisterButton;
    TextView Loginhere;
    FirebaseAuth fAuth;
     ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        FullName = findViewById(R.id.fullName);
        EmailID = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        PhoneNo = findViewById(R.id.phonenumber);
        RegisterButton = findViewById(R.id.registerButton);
        Loginhere = findViewById(R.id.textView5);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext() , Login.class));
            finish();
        }

        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String email = EmailID.getText().toString().trim();
                String password = Password.getText().toString().trim();

                // Validation of Email and password

                if(TextUtils.isEmpty(email))
                {
                    EmailID.setError("Email is required");
                    return;
                }


                if(TextUtils.isEmpty(password))
                {
                    Password.setError("Password is required");
                    return;
                }

                if(password.length()<6)
                {
                    Password.setError("Password must be atleast 6 characters");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                // registering the user in firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this , "Account Created" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext() , Login.class));

                        }
                        else
                        {
                            Toast.makeText(Register.this , "error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });


        Loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , Login.class));
            }
        });





    }
}