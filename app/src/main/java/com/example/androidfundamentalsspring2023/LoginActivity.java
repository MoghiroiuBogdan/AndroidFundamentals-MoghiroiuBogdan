package com.example.androidfundamentalsspring2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if(!email.isEmpty() && !password.isEmpty()){
            if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(LoginActivity.this, email, Toast.LENGTH_LONG).show();
            } else {
                editTextEmail.setError("please set a correct email address!");
            }
        } else {
            editTextEmail.setError("please add your email address!");
            editTextPassword.setError("please add your password!");
        }
    }
}