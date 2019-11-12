package edu.eci.cvds.entities;

import java.io.Serializable;


public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String password;
    private int rol;
    private String programaU;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String password, int rol, String programaU) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.programaU = programaU;
        this.correo = correo;
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
        return programaU;
    }

    public void setProgramaU(String programaU) {
        this.programaU = programaU;
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
                + ", programa : " + programaU + "}";
    }

}
