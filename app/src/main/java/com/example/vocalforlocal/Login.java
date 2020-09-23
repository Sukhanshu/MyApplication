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

public class Login extends AppCompatActivity {
    EditText Email, Password;
    Button LoginButton;
    TextView NewUserCreateAccountbutton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();
        LoginButton = findViewById(R.id.registerButton);
        NewUserCreateAccountbutton = findViewById(R.id.textView3);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email= Email.getText().toString().trim();
                String password= Password.getText().toString().trim();

                //Validation of Email and Password

                if (TextUtils.isEmpty(email)){
                    Email.setError("Email cannot be empty");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("password is empty");
                    return;
                }

                if(password.length()<6){
                    Password.setError(" Password should have 6 or more characters");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this , "Logged in successfully" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext() , Register.class));
                        }

                        else{
                            Toast.makeText(Login.this , "error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

     NewUserCreateAccountbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
           startActivity(new Intent(getApplicationContext(),Register.class));
         }
     });


    }
}