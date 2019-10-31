package edu.eci.cvds.security;

import edu.eci.cvds.services.BibliotecaException;



public interface Sesion {
    public void login(String correo,String password) throws BibliotecaException;
    public boolean estaLogeado();
}
