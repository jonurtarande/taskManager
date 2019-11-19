package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;

    SharedPreferences preferencias;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPwd);
        preferencias = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        editor = preferencias.edit();
        editor.putString("user","jon");
        editor.putString("password", "1234");
    }

    public void login(View view){

    }

    public void registrar(View view){

    }
}
