package edu.eci.cvds.services;

import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import java.util.Date;
import java.util.List;


public interface BibliotecaServices {

	public void registrarRecurso(Recurso rec) throws BibliotecaException;
        
        public List<Recurso> consultarRecursos()throws BibliotecaException;
        
        public List<Recurso> consultarRecursosDisponibles()throws BibliotecaException;
        
        public Recurso consultarRecurso(int id) throws BibliotecaException;
        
        public Usuario consultarUsuario(String correo) throws BibliotecaException;
        
        public void updateRecurso(int id, String nuevoEstado) throws BibliotecaException;
        
        public void registrarReserva(Reserva re) throws BibliotecaException;
        
        public void eliminarReserva(int re) throws BibliotecaException;
        
        public List<Reserva> listarReservasRecurso(int ru) throws BibliotecaException;

        public List<Reserva> consultarRecursosMasUsados() throws BibliotecaException;

        public Reserva getInfoReserva(int recursoId, Date inicio, Date fin) throws BibliotecaException;
        
        public void modificarReserva(Reserva res, EstadoReserva estado) throws BibliotecaException; 
        
        public List<Reserva> consultarRecursosMasUsadosPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMasUsadosPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMasUsadosPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMasUsadosPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
        
        public List<Reserva> consultarRecursosMenosUsadosPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMenosUsadosPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMenosUsadosPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMenosUsadosPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
    
        public List<Reserva> consultarRecursosMenosUsados() throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMayorOcupacionPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMayorOcupacionPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMayorOcupacionPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMayorOcupacionPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMayorOcupacion() throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMenorOcupacionPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMenorOcupacionPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMenorOcupacionPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMenorOcupacionPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
    
        public List<Reserva> consultarHorariosMenorOcupacion() throws BibliotecaException;
    
        public List<Reserva> consultarReservasRecurrentesPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarReservasRecurrentesPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarReservasRecurrentesPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarReservasRecurrentesPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
    
        public List<Reserva> consultarReservasRecurrentes() throws BibliotecaException;
    
        public List<Reserva> consultarReservasCanceladasPorFecha(String date1, String date2) throws BibliotecaException;
    
        public List<Reserva> consultarReservasCanceladasPorHora(String hora1, String hora2) throws BibliotecaException;
    
        public List<Reserva> consultarReservasCanceladasPorPrograma(String programa) throws BibliotecaException;
    
        public List<Reserva> consultarReservasCanceladasPorTipoRecurso(String tipoRecurso) throws BibliotecaException;
    
        public List<Reserva> consultarReservasCanceladas() throws BibliotecaException;

        public List<Reserva> consultarReservasPorCarrera() throws  BibliotecaException;

        public List<Reserva> consultarReservasPorUsuario() throws  BibliotecaException;
}
