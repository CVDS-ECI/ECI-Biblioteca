package edu.eci.cvds.entities;

import java.sql.Time;


public class Recurso {

    // El identificador es asignado por la base de datos,
    // por eso no se incluye en el constructor.
    private int id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private String estado;
    private java.sql.Time horaInicio;
    private java.sql.Time horaFin;
    
    
    


    public Recurso(int id,String nombre, String ubicacion, String tipo, int capacidad, String estado, java.sql.Time horaInicio, java.sql.Time horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.estado = estado;
        this.horaInicio= horaInicio;
        this.horaFin= horaFin;
        
    }
   public Recurso(String nombre, String ubicacion, String tipo, int capacidad, String estado, java.sql.Time horaInicio, java.sql.Time horaFin) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.estado = estado;
        this.horaInicio= horaInicio;
        this.horaFin= horaFin;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
    
    @Override
    public String toString() {
        return "Element { id: " + id + ", nombre: " + nombre + ", ubicacion: " + ubicacion
                + ", tipo: " + tipo + ", capacidad: " + capacidad + ", estado: " + estado + ", horaInicio: " + horaInicio + ", horaFin: " + horaFin +"}";
    }
}
