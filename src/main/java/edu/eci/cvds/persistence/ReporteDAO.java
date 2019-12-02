/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import java.util.List;

/**
 *
 * @author davidleon
 */
public interface ReporteDAO {
    
    List<Reserva> recursosMasUsadosPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> recursosMasUsadosPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> recursosMasUsadosPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> recursosMasUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> recursosMasUsados() throws PersistenceException;
    
    List<Reserva> recursosMenosUsadosPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> recursosMenosUsadosPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> recursosMenosUsadosPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> recursosMenosUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> recursosMenosUsados() throws PersistenceException;
    
    List<Reserva> horariosMayorOcupacionPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> horariosMayorOcupacionPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> horariosMayorOcupacionPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> horariosMayorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> horariosMayorOcupacion() throws PersistenceException;
    
    List<Reserva> horariosMenorOcupacionPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> horariosMenorOcupacionPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> horariosMenorOcupacionPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> horariosMenorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> horariosMenorOcupacion() throws PersistenceException;
    
    List<Reserva> reservasRecurrentesPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> reservasRecurrentesPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> reservasRecurrentesPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> reservasRecurrentesPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> reservasRecurrentes() throws PersistenceException;
    
    List<Reserva> reservasCanceladasPorFecha(String date1, String date2) throws PersistenceException;
    
    List<Reserva> reservasCanceladasPorHora(String hora1, String hora2) throws PersistenceException;
    
    List<Reserva> reservasCanceladasPorPrograma(String programa) throws PersistenceException;
    
    List<Reserva> reservasCanceladasPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    List<Reserva> reservasCanceladas() throws PersistenceException;

    List<Reserva> reservasPorCarrera() throws PersistenceException;

    List<Reserva> reservasPorUsuario() throws PersistenceException;
}
