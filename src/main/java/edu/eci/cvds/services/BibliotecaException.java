package edu.eci.cvds.services;

public class BibliotecaException extends Exception {
    
    public static final String USUARIO_INCORRECTO = "El usuario que ingreso es incorecto";
    
    public static final String CONTRASENA_INCORRECTA = "La contraseña ingresada es incorrecta";
    
    public static final String RECURSO_NO_EXISTE = "El recurso no existe";

    public BibliotecaException() {
    }

    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable cause) {
        super(message, cause);
    }

    public BibliotecaException(Throwable cause) {
        super(cause);
    }
    
}
