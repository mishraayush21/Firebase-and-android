package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    email = findViewById(R.id.email);
    password = findViewById(R.id.pass);
    btn = findViewById(R.id.button);
    auth = FirebaseAuth.getInstance();

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String txt_email = email.getText().toString();
            String txt_pass = password.getText().toString();
            loginuser(txt_email, txt_pass);
        }
    });


    }

    private void loginuser(String txt_email, String txt_pass) {

        auth.signInWithEmailAndPassword(txt_email, txt_pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
