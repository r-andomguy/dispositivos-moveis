package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private String userEmail;
    private String userPassword;
    private EditText setEmail;
    private  EditText setPassword;
    private Button login;
    private Button register;
    private TextView error;
    private SharedPreferences cache;
    private SharedPreferences.Editor editor;
    private String compiledUser, compiledEmail, compiledPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setEmail = findViewById(R.id.idEmail);
        setPassword = findViewById(R.id.idPassword);
        login = findViewById(R.id.buttonLogin);
        register = findViewById(R.id.userRegister);
        error = findViewById(R.id.loginError);

       Intent dataForm = getIntent();
        this.compiledUser = dataForm.getStringExtra("usuario");
        this.compiledEmail = dataForm.getStringExtra("email");
        this.compiledPassword = dataForm.getStringExtra("senha");

        cache = getSharedPreferences("arquivoUsuarios", 0);
        editor = cache.edit();
        editor.putString("userName", this.compiledUser);
        editor.putString("userEmail", this.compiledEmail);
        editor.putString("userSenha", this.compiledPassword);
        editor.commit();

        compiledUser = cache.getString("userName", "Usuário inválido");
        compiledEmail = cache.getString("userEmail", "Email inválido");
        compiledPassword = cache.getString("userSenha", "Senha inválida");


    }
    
    public void profile(View view){
        this.userEmail  = setEmail.getText().toString();
        this.userPassword = setPassword.getText().toString();

        if (userEmail.equals(compiledEmail) && (userPassword.equals(compiledPassword))){
            Intent perfil = new Intent(LoginActivity.this, ProfileActivity.class);
            perfil.putExtra("nome", "Bem-vindo " + this.compiledUser +".");
            startActivity(perfil);
        } else{
            error.setText("Email ou Senha inválida " + this.userPassword);
        }
    }

    public void openForm(View view){
        Intent cadastrar = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(cadastrar);
    }

    public void openMain(View view){
        Intent home = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(home);
    }

}