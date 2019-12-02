/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.ReporteDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaException;

import java.util.List;

public class BibliotecaServicesImpl implements BibliotecaServices {

    @Inject
    UsuarioDAO usuarioDAO;

    @Inject
    private
    RecursoDAO recursoDAO;

    @Inject
    private
    ReservaDAO reservaDAO;

    @Inject
    private
    ReporteDAO reporteDAO;

    @Override
    public void registrarRecurso(Recurso rec) throws BibliotecaException {
        try {
            recursoDAO.addRecurso(rec);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al insertar el Recurso:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        try {
            return recursoDAO.loadRecursos();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar los Recursos:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Recurso consultarRecurso(int id) throws BibliotecaException {
        try {
            return recursoDAO.loadRecurso(id);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Este Recurso:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void updateRecurso(int id, String nuevoEstado) throws BibliotecaException {
        try {
            recursoDAO.updateRecurso(id, nuevoEstado);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al Actualizar el estado de Este Recurso :" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles() throws BibliotecaException {
        try {
            return recursoDAO.loadRecursosDisponibles();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar los Recursos Disponibles:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void registrarReserva(Reserva re) throws BibliotecaException {
        try {
            reservaDAO.salvar(re);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al insertar el Recurso:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> listarReservasRecurso(int ru) throws BibliotecaException {
        try {
            return reservaDAO.listarReservasRecurso(ru);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar las reservas Disponibles:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void eliminarReserva(int re) throws BibliotecaException {
        try {
            reservaDAO.remover(re);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar las reservas Disponibles:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMasUsados() throws BibliotecaException {
        try {
            return reporteDAO.recursosMasUsados();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar recursos mas usados" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMasUsadosPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.recursosMasUsadosPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Mas Usados Por Fecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMasUsadosPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.recursosMasUsadosPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Mas Usados Por Hora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMasUsadosPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.recursosMasUsadosPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Mas Usados Por Programa" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMasUsadosPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.recursosMasUsadosPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Mas Usados Por TipoRecurso" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMenosUsadosPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.recursosMenosUsadosPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Menos Usados Por Fecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMenosUsadosPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.recursosMenosUsadosPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Menos Usados Por Hora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMenosUsadosPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.recursosMenosUsadosPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Recursos Menos Usados Por Programa" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMenosUsadosPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.recursosMenosUsadosPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar recursos Menos Usados Por Tipo Recurso" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarRecursosMenosUsados() throws BibliotecaException {
        try {
            return reporteDAO.recursosMenosUsados();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar recursos Menos Usados" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacionPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.horariosMayorOcupacionPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Mayor Ocupacion Por Fecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacionPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.horariosMayorOcupacionPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Mayor Ocupacion PorHora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacionPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.horariosMayorOcupacionPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Mayor Ocupacion PorPrograma" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacionPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.horariosMayorOcupacionPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Mayor Ocupacion Por Tipo Recursos" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacion() throws BibliotecaException {
        try {
            return reporteDAO.horariosMayorOcupacion();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Mayor Ocupacion" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMenorOcupacionPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.horariosMenorOcupacionPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Menor Ocupacion Por Fecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMenorOcupacionPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.horariosMenorOcupacionPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Menor Ocupacion PorHora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMenorOcupacionPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.horariosMenorOcupacionPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Menor Ocupacion Por Programa" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMenorOcupacionPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.horariosMenorOcupacionPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Menor Ocupacion Por TipoRecurso" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMenorOcupacion() throws BibliotecaException {
        try {
            return reporteDAO.horariosMenorOcupacion();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Horarios Menor Ocupacion" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurrentesPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.reservasRecurrentesPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Recurrentes PorFecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurrentesPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.reservasRecurrentesPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Recurrentes PorHora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurrentesPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.reservasRecurrentesPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Recurrentes PorPrograma" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurrentesPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.reservasRecurrentesPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Recurrentes Por TipoRecurso" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurrentes() throws BibliotecaException {
        try {
            return reporteDAO.reservasRecurrentes();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Recurrentes" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladasPorFecha(String date1, String date2) throws BibliotecaException {
        try {
            return reporteDAO.reservasCanceladasPorFecha(date1, date2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Canceladas PorFecha" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladasPorHora(String hora1, String hora2) throws BibliotecaException {
        try {
            return reporteDAO.reservasCanceladasPorHora(hora1, hora2);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Canceladas PorHora" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladasPorPrograma(String programa) throws BibliotecaException {
        try {
            return reporteDAO.reservasCanceladasPorPrograma(programa);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Canceladas Por Programa" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladasPorTipoRecurso(String tipoRecurso) throws BibliotecaException {
        try {
            return reporteDAO.reservasCanceladasPorTipoRecurso(tipoRecurso);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Canceladas Por TipoRecurso" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladas() throws BibliotecaException {
        try {
            return reporteDAO.reservasCanceladas();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas Canceladas" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasPorCarrera() throws BibliotecaException {
        try {
            return reporteDAO.reservasPorCarrera();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas por carrera" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasPorUsuario() throws BibliotecaException {
        try {
            return reporteDAO.reservasPorUsuario();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar Reservas por carrera" + ex.getLocalizedMessage(), ex);
        }
    }


}
