package com.example.taskmanager;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea implements Serializable {

    private int idTarea;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private double precio;
    private Prioridad prioridad;
    private boolean tareaFinalizada;

    public Tarea(){}

    public Tarea(int idTarea, String nombre, String descripcion, Date fecha, double precio, Prioridad prioridad, boolean tareaFinalizada) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.prioridad = prioridad;
        this.tareaFinalizada = tareaFinalizada;
    }

    public Tarea(int idTarea, String nombre, String descripcion, String fecha, double precio, String prioridad, int tareaFinalizada){
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = strToDate(fecha);
        this.precio = precio;
        this.prioridad = strToPrioridad(prioridad);
        this.tareaFinalizada = intToBoolean(tareaFinalizada);
    }

    private Date strToDate(String fecha){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(fecha);
        }catch (ParseException e){
            return null;
        }
    }

    private Prioridad strToPrioridad(String prioridad){
        prioridad = prioridad.toUpperCase();
        switch (prioridad){
            case "URGENTE": return Prioridad.URGENTE;
            case "ALTA": return Prioridad.ALTA;
            case "MEDIA": return Prioridad.MEDIA;
            case "BAJA": return Prioridad.BAJA;
            default: return null;
        }
    }

    private boolean intToBoolean(int binary){
        if(binary == 0) return false;
        else return true;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isTareaFinalizada() {
        return tareaFinalizada;
    }

    public void setTareaFinalizada(boolean tareaFinalizada) {
        this.tareaFinalizada = tareaFinalizada;
    }
}
