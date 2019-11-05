package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "AdminBean", eager =true)
@SessionScoped
public class AdminBean extends BasePageBean {
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private String estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Inject
    private BibliotecaServices serviciosBiblioteca;

    /**
     * Registra un nuevo recurso a la base de datos. (Hecho para el administador)
     *
     * @param nombre    Nombre del recurso
     * @param ubicacion Ubicación del recurso
     * @param tipo      Tipo del recurso
     * @param capacidad Capacidad del recurso
     * @param estado    Estado del recurso (Disponible/Ocupado/En mantenimiento)
     */
    public void registrarRecurso(String nombre, String ubicacion, String tipo, int capacidad, String estado) {
        try {
            serviciosBiblioteca.registrarRecurso(new Recurso(nombre, ubicacion, tipo, capacidad, estado));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Consulta todos los recursos. (Hecho para el administador)
     *
     * @return Lista de todos los recursos
     */
    public List<Recurso> consultarRecursos() {
        List<Recurso> recursos = new ArrayList<>();
        try {
            recursos = serviciosBiblioteca.consultarRecursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }

    /**
     * Consulta un recurso dado su ID
     * @param id
     * @return
     */
    public Recurso consultarRecurso(int id) {
        Recurso recurso = null;
        try {
            recurso = serviciosBiblioteca.consultarRecurso(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;
    }

}
