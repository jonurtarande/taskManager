package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
    }

    public void addTask(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"admin",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
    }
}
