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

        initComponents();
        setPreferences();
    }

    private void setPreferences() {
        preferencias = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        editor = preferencias.edit();
        editor.putString("user","jon");
        editor.putString("password", "1234");
        editor.commit();
    }

    private void initComponents() {
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPwd);
    }

    public void login(View view){
        if(etUser.getText().toString().equals(preferencias.getString("user",""))){
            if(etPassword.getText().toString().equals(preferencias.getString("password",""))){
                Intent activity = new Intent(this, TasksActivity.class);
                startActivity(activity);
            }else
                Toast.makeText(this,R.string.wrong_pass,Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this,R.string.wrong_user,Toast.LENGTH_LONG).show();
    }

}
