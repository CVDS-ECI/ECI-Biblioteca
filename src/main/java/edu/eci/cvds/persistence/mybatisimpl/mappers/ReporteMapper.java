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

    List<Reserva> recursosMasUsadosPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> recursosMasUsadosPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> recursosMasUsadosPorPrograma(@Param("program") String programa);
    
    List<Reserva> recursosMasUsadosPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> recursosMasUsados();
    
    List<Reserva> recursosMenosUsadosPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> recursosMenosUsadosPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> recursosMenosUsadosPorPrograma(@Param("program") String programa);
    
    List<Reserva> recursosMenosUsadosPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> recursosMenosUsados();
    
    List<Reserva> horariosMayorOcupacionPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> horariosMayorOcupacionPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> horariosMayorOcupacionPorPrograma(@Param("program") String programa);
    
    List<Reserva> horariosMayorOcupacionPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> horariosMayorOcupacion();
    
    List<Reserva> horariosMenorOcupacionPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> horariosMenorOcupacionPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> horariosMenorOcupacionPorPrograma(@Param("program") String programa);
    
    List<Reserva> horariosMenorOcupacionPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> horariosMenorOcupacion();
    
    List<Reserva> reservasRecurrentesPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> reservasRecurrentesPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> reservasRecurrentesPorPrograma(@Param("program") String programa);
    
    List<Reserva> reservasRecurrentesPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> reservasRecurrentes();
    
    List<Reserva> reservasCanceladasPorFecha(@Param("fechaInicio") String date1, @Param("fechaFin") String date2);
    
    List<Reserva> reservasCanceladasPorHora(@Param("horaInicio") String hora1, @Param("horaFin") String hora2);
    
    List<Reserva> reservasCanceladasPorPrograma(@Param("program") String programa);
    
    List<Reserva> reservasCanceladasPorTipoRecurso(@Param("tipoRecurso") String tipoRecurso);
    
    List<Reserva> reservasCanceladas();

    List<Reserva> reservasPorCarrera();

    List<Reserva> reservasPorUsuario();
}
