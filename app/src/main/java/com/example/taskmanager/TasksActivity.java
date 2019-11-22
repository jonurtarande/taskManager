package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    private TaskListAdapter adapter;
    private ListView listaTareas;
    private ArrayList<Tarea> tareas;
    private AdminSQLiteOpenHelper dbAdmin;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        initComponents();
        initDB();
    }

    private void initDB() {
        dbAdmin = new AdminSQLiteOpenHelper(this,"dbTasks",null,1);
        db = dbAdmin.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM tarea",null);
        if(c.moveToFirst()){
            do{
                int idTarea = c.getInt(0);
                String nombre = c.getString(1);
                String descripcion = c.getString(2);
                String fecha = c.getString(3);
                double precio = c.getDouble(4);
                String prioridad = c.getString(5);
                int finalizada = c.getInt(6);
                Tarea tarea = new Tarea(idTarea,nombre,descripcion,fecha,precio,prioridad,finalizada);
                tareas.add(tarea);
            }while(c.moveToNext());
        }
        db.close();
    }

    private void initComponents() {
        tareas = new ArrayList<Tarea>();
        adapter = new TaskListAdapter(this, R.layout.tarea, tareas);
        listaTareas = (ListView) findViewById(R.id.lstTarea);
        listaTareas.setAdapter(adapter);
        registerForContextMenu(listaTareas);
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
            Intent activity = new Intent(this, NewTaskActivity.class);
            startActivity(activity);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle(R.string.task_options);
        getMenuInflater().inflate(R.menu.context_menu_task, menu);
    }
    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.itmEditTask:
                lblMensaje.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.itmDeleteTask:
                lblMensaje.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            case R.id.itmDone:
                lblMensaje.setText("Lista[" + info.position + "]: Opcion 1 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }*/

    public void editTask(View view){

    }

    public void deleteTask(View view){

    }

    public void setDone(View view){

    }

}
