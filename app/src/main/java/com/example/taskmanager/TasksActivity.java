package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    private TareaAdapter adapter;
    private ListView listaTareas;
    private ArrayList<Tarea> tareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        adapter = new TareaAdapter(this, R.layout.tarea, tareas);
        listaTareas = (ListView) findViewById(R.id.lstTarea);
        listaTareas.setAdapter(adapter);
    }

    public void addTask(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"admin",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
    }

    public void editTask(View view){

    }

    public void deleteTask(View view){

    }
}
