package com.example.taskmanager;

import java.util.Date;

public class Tarea {

    private String nombre;
    private String descripcion;
    private Date fecha;
    private double coste;
    private Prioridad prioridad;
    private boolean tareaFinalizada;

    public Tarea(){}

    public Tarea(String nombre, String descripcion, Date fecha, double coste, Prioridad prioridad, boolean tareaFinalizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.coste = coste;
        this.prioridad = prioridad;
        this.tareaFinalizada = tareaFinalizada;
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

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
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
