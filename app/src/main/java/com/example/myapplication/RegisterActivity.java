package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private String user = "user";
    private String email ="email";
    private String password = "password";

    private EditText setUser;
    private EditText setEmail;
    private EditText setPassword;
    private Button registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        setUser = findViewById(R.id.idUserRegister);
        setEmail = findViewById(R.id.idEmailRegister);
        setPassword = findViewById(R.id.idPasswordRegister);
        registerUser = findViewById(R.id.registerUser);
    }

    public void mainAction(View view){
        Intent home = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(home);
    }

    public void loginAction(View view){
        Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(login);
    }

    public void formAction(View view){
        this.user = setUser.getText().toString();
        this.email = setEmail.getText().toString();
        this.password = setPassword.getText().toString();

        Intent home = new Intent(RegisterActivity.this, LoginActivity.class);
        home.putExtra("usuario", this.user);
        home.putExtra("email", this.email);
        home.putExtra("senha", this.password);
        Toast.makeText(this, "enviado para o form " + this.password + this.email + this.user , Toast.LENGTH_SHORT).show();

       startActivity(home);
    }

}