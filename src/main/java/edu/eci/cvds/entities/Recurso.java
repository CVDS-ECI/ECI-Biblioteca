package edu.eci.cvds.entities;

import java.sql.Date;

public class Recurso {

    // El identificador es asignado por la base de datos,
    // por eso no se incluye en el constructor.
    private int id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private boolean estado;

    public Recurso() {
    }

    public Recurso(int id, String nombre, String ubicacion, String tipo, int capacidad, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.estado = estado;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Element { id: " + id + ", nombre: " + nombre + ", ubicacion: " + ubicacion
                + ", tipo: " + tipo + ", capacidad: " + capacidad + ", estado: " + estado + "}";
    }
}
