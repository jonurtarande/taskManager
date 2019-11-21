package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;

    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;

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
        //preferencias.getString("user",null);
        //preferencias.getString("password",null);
        if(etUser.getText().toString().equals(preferencias.getString("user",null))){
            if(etPassword.getText().toString().equals(preferencias.getString("password",null))){
                Intent activity = new Intent(this, TasksActivity.class);
            }else
                Toast.makeText(this,R.string.wrong_pass,Toast.LENGTH_LONG);
        }else
            Toast.makeText(this,R.string.wrong_user,Toast.LENGTH_LONG);

    }

    public void registrar(View view){

    }
}
