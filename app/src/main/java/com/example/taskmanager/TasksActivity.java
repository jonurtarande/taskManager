package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        registerForContextMenu(listaTareas.getSelectedView());
        /*
        listaTareas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getMenuInflater().inflate(R.menu.context_menu_task,);



                return false;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.itmNewTask) {
            // Lanzar activity_new_task
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle(R.string.action);
        getMenuInflater().inflate(R.menu.context_menu_task, menu);
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
