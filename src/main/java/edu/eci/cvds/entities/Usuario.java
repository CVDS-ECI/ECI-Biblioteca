package edu.eci.cvds.entities;

import java.io.Serializable;


public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String password;
    private int rol;
    private String programa;
    private String carrera;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String password, int rol, String programa,String carrera) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.programa = programa;
        this.correo = correo;
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getProgramaU() {
        return programa;
    }

    public void setProgramaU(String programa) {
        this.programa = programa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario { correo : " + correo + ", nombre: " + nombre + ", rol: " + rol
                + ", programa : " + programa + "}";
    }

}
