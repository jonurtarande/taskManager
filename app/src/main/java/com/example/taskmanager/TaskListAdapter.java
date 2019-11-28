package com.example.taskmanager;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Tarea> {

    private AppCompatActivity context;
    private int layout;
    private ArrayList<Tarea> tareas;

    public TaskListAdapter(AppCompatActivity context, int layout, ArrayList<Tarea> tareas){
        super(context, R.layout.tarea, tareas);
        this.context = context;
        this.layout = layout;
        this.tareas = tareas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = context.getLayoutInflater().inflate(layout, null);

        ImageView imgPrioridad = item.findViewById(R.id.imgPrioridad);
        switch (tareas.get(position).getPrioridad().toString()){
            // Cambiar imagenes
            case "URGENTE": imgPrioridad.setImageResource(R.drawable.login);break;
            case "ALTA": imgPrioridad.setImageResource(R.drawable.login);break;
            case "MEDIA": imgPrioridad.setImageResource(R.drawable.login);break;
            case "BAJA": imgPrioridad.setImageResource(R.drawable.login);break;
        }
        TextView txtTarea = item.findViewById(R.id.txtTarea);
        txtTarea.setText(tareas.get(position).getNombre());

        return item;
    }
}