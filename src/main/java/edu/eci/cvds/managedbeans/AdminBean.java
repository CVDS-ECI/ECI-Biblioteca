package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name = "AdminBean", eager = true)
@SessionScoped
public class AdminBean extends BasePageBean {

    @Inject
    private BibliotecaServices serviciosBiblioteca;
    private String[] TiposDeRecursos = {"Sala", "Equipo de computo", "Equipo de multimedia", "Libro"};
    private String[] TiposDeEstados = {"Disponible", "En Mantenimiento", "No Disponible"};
    private String[] TiposDeUbicacion = {"Biblioteca JAL Bloque B", "Biblioteca JAL Bloque G"};
    private String tipoDeRecursoSeleccionado;
    private String tipoDeEstadoSeleccionado;
    private String tipoDeEstadoSeleccionado2;
    private String tipoDeUbicacionSeleccionada;

    /**
     * Registra un nuevo recurso a la base de datos. (Hecho para el
     * administador)
     *
     * @param nombre Nombre del recurso
     * @param ubicacion Ubicación del recurso
     * @param tipo Tipo del recurso
     * @param capacidad Capacidad del recurso
     * @param estado Estado del recurso (Disponible/Ocupado/En mantenimiento)
     */
    public void registrarRecurso(String nombre, int capacidad) {
        try {
            serviciosBiblioteca.registrarRecurso(new Recurso(nombre, tipoDeUbicacionSeleccionada, tipoDeRecursoSeleccionado, capacidad, tipoDeEstadoSeleccionado));
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
     *
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
    
    public void cambiarEstadoRecurso(int id){
        try {
            System.err.println(tipoDeEstadoSeleccionado2);
            serviciosBiblioteca.updateRecurso(id, tipoDeEstadoSeleccionado2);
        } catch (BibliotecaException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getTiposDeRecursos() {
        return TiposDeRecursos;
    }

    public void setTiposDeRecursos(String[] tiposDeRecursos) {
        TiposDeRecursos = tiposDeRecursos;
    }

    public String[] getTiposDeEstados() {
        return TiposDeEstados;
    }

    public void setTiposDeEstados(String[] tiposDeEstados) {
        TiposDeEstados = tiposDeEstados;
    }

    public String[] getTiposDeUbicacion() {
        return TiposDeUbicacion;
    }

    public void setTiposDeUbicacion(String[] tiposDeUbicacion) {
        TiposDeUbicacion = tiposDeUbicacion;
    }

    public String getTipoDeRecursoSeleccionado() {
        return tipoDeRecursoSeleccionado;
    }

    public void setTipoDeRecursoSeleccionado(String tipoDeRecursoSeleccionado) {
        this.tipoDeRecursoSeleccionado = tipoDeRecursoSeleccionado;
    }

    public String getTipoDeEstadoSeleccionado() {
        return tipoDeEstadoSeleccionado;
    }

    public void setTipoDeEstadoSeleccionado(String tipoDeEstadoSeleccionado) {
        this.tipoDeEstadoSeleccionado = tipoDeEstadoSeleccionado;
    }

    public String getTipoDeUbicacionSeleccionada() {
        return tipoDeUbicacionSeleccionada;
    }

    public void setTipoDeUbicacionSeleccionada(String tipoDeUbicacionSeleccionada) {
        this.tipoDeUbicacionSeleccionada = tipoDeUbicacionSeleccionada;
    }
    public String getTipoDeEstadoSeleccionado2() {
        return tipoDeEstadoSeleccionado2;
    }

    public void setTipoDeEstadoSeleccionado2(String tipoDeEstadoSeleccionado2) {
        this.tipoDeEstadoSeleccionado2 = tipoDeEstadoSeleccionado2;
    }

}
