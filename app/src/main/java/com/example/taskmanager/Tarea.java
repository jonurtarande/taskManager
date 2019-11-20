package com.example.taskmanager;

import java.util.Date;

public class Tarea {

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

    public int getIdTarea() {return idTarea;}

    public void setIdTarea(int idTarea) {this.idTarea = idTarea;}

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
