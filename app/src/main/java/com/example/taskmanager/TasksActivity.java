package com.example.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    //private TabItem tabDone;
    //private TabItem tabUndone;
    //private TabItem tabAll;
    private TabLayout tabs;
    private TaskListAdapter adapter;
    private ListView listaTareas;
    private ArrayList<Tarea> tareas;
    private ArrayList<Tarea> done;
    private ArrayList<Tarea> undone;
    private AdminSQLiteOpenHelper dbAdmin;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        initComponents();
        initDB();
        adapter = new TaskListAdapter(this, R.layout.tarea, tareas);
        listaTareas.setAdapter(adapter);
        registerForContextMenu(listaTareas);

    }

    private void initComponents() {
        tareas = new ArrayList<Tarea>();
        done = new ArrayList<Tarea>();
        undone = new ArrayList<Tarea>();
        listaTareas = (ListView) findViewById(R.id.lstTarea);
        tabs = (TabLayout) findViewById(R.id.lytTab);
    }

    public void showAll(View view){
        adapter = new TaskListAdapter(this, R.layout.tarea, tareas);
        listaTareas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void showDone(View view){
        adapter = new TaskListAdapter(this, R.layout.tarea, done);
        listaTareas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void showUndone(View view){
        adapter = new TaskListAdapter(this, R.layout.tarea, undone);
        listaTareas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setDone(){
        for(Tarea tarea:tareas){
            if(tarea.isTareaFinalizada())
                done.add(tarea);
        }
    }

    private void setUnDone(){
        for(Tarea tarea:tareas){
            if(!tarea.isTareaFinalizada())
                undone.add(tarea);
        }
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
        setDone();
        setUnDone();
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

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.itmEditTask:
                Intent activity = new Intent(this,EditTaskActivity.class);
                activity.putExtra("id", tareas.get(info.position).getIdTarea());
                startActivity(activity);
                return true;
            case R.id.itmDeleteTask:
                dbAdmin = new AdminSQLiteOpenHelper(this,"dbTasks",null,1);
                db = dbAdmin.getWritableDatabase();
                db.delete("tarea", "idTarea = " + tareas.get(info.position).getIdTarea(),null);
                Intent activity2 = new Intent(this,TasksActivity.class);
                startActivity(activity2);
                return true;
            case R.id.itmDone:
                dbAdmin = new AdminSQLiteOpenHelper(this,"dbTasks",null,1);
                db = dbAdmin.getWritableDatabase();
                ContentValues values = new ContentValues();
                if(tareas.get(info.position).isTareaFinalizada())
                   values.put("finalizada",0);
                else
                    values.put("finalizada",1);
                db.update("tarea",values,"idTarea="+tareas.get(info.position).getIdTarea(),null);
                Intent activity3 = new Intent(this,TasksActivity.class);
                startActivity(activity3);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
