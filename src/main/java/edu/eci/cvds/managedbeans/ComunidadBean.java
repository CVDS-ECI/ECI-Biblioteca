/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "comunidadBean", eager = true)
@SessionScoped
/**
 *
 * @author davidleon
 */
public class ComunidadBean extends BasePageBean{
    @Inject
    private BibliotecaServices serviciosBiblioteca;

    private String duracionSeleccionada;
    private String recurrenciaSeleccionada;



    /**
     * Consulta todos los recursos. (Hecho para el administador)
     *
     * @return Lista de todos los recursos
     */
    public List<Recurso> consultarRecursosDisponibles() {
        List<Recurso> recursos = new ArrayList<>();
        try {
            recursos = serviciosBiblioteca.consultarRecursosDisponibles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }

    private void realizarReserva() {

    }
    public void realizarReserva(String fechaInicio){
        try{
            //serviciosBiblioteca.realizarReserva();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getDuracionSeleccionada() {
        return duracionSeleccionada;
    }

    public void setDuracionSeleccionada(String duracionSeleccionada) {
        this.duracionSeleccionada = duracionSeleccionada;
    }

    public String getRecurrenciaSeleccionada() {
        return recurrenciaSeleccionada;
    }

    public void setRecurrenciaSeleccionada(String recurrenciaSeleccionada) {
        this.recurrenciaSeleccionada = recurrenciaSeleccionada;
    }
}

