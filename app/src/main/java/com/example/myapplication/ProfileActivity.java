package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);

        Intent intent = getIntent();
        String hello = intent.getStringExtra("user");

        TextView getHello = findViewById(R.id.helloWorld);
        getHello.setText(hello);

    }

    public  void profileArea(View view){
        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
        Toast.makeText(this, "Até breve", Toast.LENGTH_SHORT).show();
        startActivity(i);

    }
}