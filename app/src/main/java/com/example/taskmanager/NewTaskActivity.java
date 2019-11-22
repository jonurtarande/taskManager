package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etDescripcion;
    private EditText etFecha;
    private EditText etPrecio;
    private Spinner spnPrioridad;

    private AdminSQLiteOpenHelper dbAdmin;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        initComponents();

    }

    private void initComponents() {
        etNombre = findViewById(R.id.etNombre);
        etDescripcion = findViewById(R.id.etDescripcion);
        etFecha = findViewById(R.id.etFecha);
        etPrecio = findViewById(R.id.etPrecio);
        spnPrioridad = findViewById(R.id.spnPrioridad);
    }

    private boolean validarCampos(){

        return true;
    }


    public void createTask(View view){
        if(validarCampos()){
           openDB();
           insertTarea();
        }
    }

    private void openDB(){
        dbAdmin = new AdminSQLiteOpenHelper(this,"dbTasks",null,1);
        db = dbAdmin.getWritableDatabase();
    }

    private void insertTarea() {
        ContentValues values = new ContentValues();
        values.put("nombre",etNombre.getText().toString());
        values.put("descripcion", etDescripcion.getText().toString());
        values.put("fecha",etFecha.getText().toString());
        values.put("precio", etPrecio.getText().toString());
        values.put("prioridad", spnPrioridad.getSelectedItem().toString());
        db.insert("tarea",null, values);
        db.close();
    }

    public void cancel(View view){
        finish();
    }
}
