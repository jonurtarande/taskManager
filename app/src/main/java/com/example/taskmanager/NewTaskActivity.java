package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        etNombre = findViewById(R.id.etNewNombre);
        etDescripcion = findViewById(R.id.etNewDescripcion);
        etFecha = findViewById(R.id.etNewFecha);
        etPrecio = findViewById(R.id.etNewPrecio);
        spnPrioridad = findViewById(R.id.spnNewPrioridad);
        spnPrioridad.setAdapter(new ArrayAdapter<Prioridad>(this, android.R.layout.simple_spinner_item, Prioridad.values()));
    }

    public void mostrarCalendario(View view) {
        switch (view.getId()) {
            case R.id.etNewFecha:
                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        final String selectedDate = day + "/" + (month+1) + "/" + year;
                        etFecha.setText(selectedDate);
                    }
                });
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;
        }
    }

    private boolean validarCampos(){
        if(etNombre.equals("") || etDescripcion.equals("") || etFecha.equals(""))
            return false;
        else
            return true;
    }


    public void createTask(View view){
        if(validarCampos()){
           openDB();
           insertTarea();
           Intent activity = new Intent(this,TasksActivity.class);
           startActivity(activity);
        }else
            Toast.makeText(this,R.string.error_on_create,Toast.LENGTH_SHORT).show();
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
        values.put("finalizada", 0);
        db.insert("tarea",null, values);
        db.close();
    }

    public void cancel(View view){
        finish();
    }
}