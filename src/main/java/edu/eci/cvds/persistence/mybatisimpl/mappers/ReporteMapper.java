/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 *
 * @author davidleon
 */
public interface ReporteMapper {

    public List<Reserva> recursosMasUsadosPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> recursosMasUsadosPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> recursosMasUsadosPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> recursosMasUsadosPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> recursosMasUsados();
    
    public List<Reserva> recursosMenosUsadosPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> recursosMenosUsadosPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> recursosMenosUsadosPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> recursosMenosUsadosPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> recursosMenosUsados();
    
    public List<Reserva> horariosMayorOcupacionPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> horariosMayorOcupacionPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> horariosMayorOcupacionPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> horariosMayorOcupacionPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> horariosMayorOcupacion();
    
    public List<Reserva> horariosMenorOcupacionPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> horariosMenorOcupacionPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> horariosMenorOcupacionPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> horariosMenorOcupacionPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> horariosMenorOcupacion();
    
    public List<Reserva> reservasRecurrentesPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> reservasRecurrentesPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> reservasRecurrentesPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> reservasRecurrentesPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> reservasRecurrentes();
    
    public List<Reserva> reservasCanceladasPorFecha(@Param ("fechaInicio") String date1, @Param ("fechaFin") String date2);
    
    public List<Reserva> reservasCanceladasPorHora(@Param ("horaInicio") String hora1, @Param ("horaFin") String hora2);
    
    public List<Reserva> reservasCanceladasPorPrograma(@Param ("program") String programa);
    
    public List<Reserva> reservasCanceladasPorTipoRecurso(@Param ("tipoRecurso") String tipoRecurso);
    
    public List<Reserva> reservasCanceladas();
    
}
