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

public class TareaAdapter extends ArrayAdapter<Tarea> {

    private AppCompatActivity context;
    private int layout;
    private ArrayList<Tarea> tareas;

    public TareaAdapter(AppCompatActivity context, int layout, ArrayList<Tarea> tareas){
        super(context, R.layout.tarea, tareas);
        this.context = context;
        this.layout = layout;
        this.tareas = tareas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.tarea, null);

        ImageView imgPrioridad = item.findViewById(R.id.imgPrioridad);
        switch (tareas.get(position).getPrioridad()){
            case URGENTE: imgPrioridad.setImageResource(R.drawable.login); // Subir imgs a recursos
            case ALTA: imgPrioridad.setImageResource(R.drawable.login);
            case MEDIA: imgPrioridad.setImageResource(R.drawable.login);
            case BAJA: imgPrioridad.setImageResource(R.drawable.login);
        }
        TextView txtTarea = item.findViewById(R.id.txtTarea);
        txtTarea.setText(tareas.get(position).getNombre());

        return item;
    }
}
