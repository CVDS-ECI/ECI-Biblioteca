/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReporteDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReporteMapper;
import java.util.List;

/**
 *
 * @author davidleon
 */
public class MyBatisReporteDAO implements ReporteDAO{
    
    @Inject
    private ReporteMapper reporteMapper;

    @Override
    public List<Reserva> recursosMasUsadosPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.recursosMasUsadosPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Mas Usados PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMasUsadosPorHora(String hora1, String hora2) throws PersistenceException{
        try{
             return reporteMapper.recursosMasUsadosPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Mas Usados PorHora",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMasUsadosPorPrograma(String programa) throws PersistenceException{
        try{
             return reporteMapper.recursosMasUsadosPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos MasUsados PorPrograma",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMasUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.recursosMasUsadosPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Mas Usados PorTipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMasUsados() throws PersistenceException {
        try{
             return reporteMapper.recursosMasUsados();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos MasUsados",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMenosUsadosPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.recursosMenosUsadosPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Menos Usados PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMenosUsadosPorHora(String hora1, String hora2) throws PersistenceException {
        try{
             return reporteMapper.recursosMenosUsadosPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Menos Usados PorHora",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMenosUsadosPorPrograma(String programa) throws PersistenceException {
        try{
             return reporteMapper.recursosMenosUsadosPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Menos Usados PorPrograma",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMenosUsadosPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.recursosMenosUsadosPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos Menos Usados Por TipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> recursosMenosUsados() throws PersistenceException {
        try{
             return reporteMapper.recursosMenosUsados();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar recursos MenosUsados",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMayorOcupacionPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.horariosMayorOcupacionPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Mayor Ocupacion PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMayorOcupacionPorHora(String hora1, String hora2) throws PersistenceException {
        try{
             return reporteMapper.horariosMayorOcupacionPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Mayor Ocupacion PorHora",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMayorOcupacionPorPrograma(String programa) throws PersistenceException {
        try{
             return reporteMapper.horariosMayorOcupacionPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Mayor Ocupacion Por Programa",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMayorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.horariosMayorOcupacionPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Mayor Ocupacion Por TipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMayorOcupacion() throws PersistenceException {
        try{
             return reporteMapper.horariosMayorOcupacion();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Mayor Ocupacion",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMenorOcupacionPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.horariosMenorOcupacionPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Menor Ocupacion PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMenorOcupacionPorHora(String hora1, String hora2) throws PersistenceException {
        try{
             return reporteMapper.horariosMenorOcupacionPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Menor Ocupacion Por Hora",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMenorOcupacionPorPrograma(String programa) throws PersistenceException {
        try{
             return reporteMapper.horariosMenorOcupacionPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Menor Ocupacion Por Programa",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMenorOcupacionPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.horariosMenorOcupacionPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Menor Ocupacion Por TipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> horariosMenorOcupacion() throws PersistenceException {
        try{
             return reporteMapper.horariosMenorOcupacion();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar horarios Menor Ocupacion()",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasRecurrentesPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.reservasRecurrentesPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Recurrentes PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasRecurrentesPorHora(String hora1, String hora2) throws PersistenceException {
        try{
             return reporteMapper.reservasRecurrentesPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Recurrentes PorHora",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasRecurrentesPorPrograma(String programa) throws PersistenceException {
        try{
             return reporteMapper.reservasRecurrentesPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Recurrentes Por Programa",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasRecurrentesPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.reservasRecurrentesPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Recurrentes Por TipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasRecurrentes() throws PersistenceException {
        try{
             return reporteMapper.reservasRecurrentes();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Recurrentes",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasCanceladasPorFecha(String date1, String date2) throws PersistenceException {
        try{
             return reporteMapper.reservasCanceladasPorFecha(date1, date2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Canceladas PorFecha",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasCanceladasPorHora(String hora1, String hora2) throws PersistenceException {
        try{
             return reporteMapper.reservasCanceladasPorHora(hora1, hora2);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Canceladas PorHora",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasCanceladasPorPrograma(String programa) throws PersistenceException {
        try{
             return reporteMapper.reservasCanceladasPorPrograma(programa);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Canceladas PorPrograma",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasCanceladasPorTipoRecurso(String tipoRecurso) throws PersistenceException {
        try{
             return reporteMapper.reservasCanceladasPorTipoRecurso(tipoRecurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Canceladas Por TipoRecurso",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasCanceladas() throws PersistenceException {
        try{
             return reporteMapper.reservasCanceladas();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al consultar reservas Canceladas()",e);
             
         }	
    }

    @Override
    public List<Reserva> reservasPorCarrera() throws PersistenceException {
        try{
            return reporteMapper.reservasPorCarrera();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){

            throw new PersistenceException("Error al consultar reservas por carrera()",e);

        }
    }

    @Override
    public List<Reserva> reservasPorUsuario() throws PersistenceException {
        try{
            return reporteMapper.reservasPorUsuario();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){

            throw new PersistenceException("Error al consultar reservas por carrera()",e);

        }
    }

}
