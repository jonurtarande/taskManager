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
           getTarea();
        }
    }

    private void openDB(){
        dbAdmin = new AdminSQLiteOpenHelper(this,"dbTasks",null,1);
        db = dbAdmin.getWritableDatabase();
    }

    private void getTarea() {
        String nombre = etNombre.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String fecha = etFecha.getText().toString();
        String precio = etPrecio.getText().toString();
        String prioridad = spnPrioridad.getSelectedItem().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("descripcion", descripcion);
        registro.put("fecha",fecha);
        registro.put("precio", precio);
        registro.put("prioridad", prioridad);
        //Seguir por aqui
    }

    public void cancel(View view){

    }
}
