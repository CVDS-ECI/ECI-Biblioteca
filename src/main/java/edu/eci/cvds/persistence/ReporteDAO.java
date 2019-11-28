/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author davidleon
 */
public interface ReporteDAO {
    
    public List<Reserva> recursosMasUsadosPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> recursosMasUsadosPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> recursosMasUsadosPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> recursosMasUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> recursosMasUsados() throws PersistenceException;
    
    public List<Reserva> recursosMenosUsadosPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> recursosMenosUsadosPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> recursosMenosUsadosPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> recursosMenosUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> recursosMenosUsados() throws PersistenceException;
    
    public List<Reserva> horariosMayorOcupacionPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> horariosMayorOcupacionPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> horariosMayorOcupacionPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> horariosMayorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> horariosMayorOcupacion() throws PersistenceException;
    
    public List<Reserva> horariosMenorOcupacionPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> horariosMenorOcupacionPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> horariosMenorOcupacionPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> horariosMenorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> horariosMenorOcupacion() throws PersistenceException;
    
    public List<Reserva> reservasRecurrentesPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> reservasRecurrentesPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> reservasRecurrentesPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> reservasRecurrentesPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> reservasRecurrentes() throws PersistenceException;
    
    public List<Reserva> reservasCanceladasPorFecha(String date1, String date2) throws PersistenceException;
    
    public List<Reserva> reservasCanceladasPorHora(String hora1, String hora2) throws PersistenceException;
    
    public List<Reserva> reservasCanceladasPorPrograma(String programa) throws PersistenceException;
    
    public List<Reserva> reservasCanceladasPorTipoRecurso(String tipoRecurso) throws PersistenceException;
    
    public List<Reserva> reservasCanceladas() throws PersistenceException;
}
