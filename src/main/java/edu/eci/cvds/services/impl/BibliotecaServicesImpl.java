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
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaException;
import java.util.Date;

import java.util.List;

public class BibliotecaServicesImpl implements BibliotecaServices {

    @Inject
    UsuarioDAO usuarioDAO;
    
    @Inject
    RecursoDAO recursoDAO;
    
    @Inject
    ReservaDAO reservaDAO;

    @Override
    public void registrarRecurso(Recurso rec)throws BibliotecaException {
        try {
            recursoDAO.addRecurso(rec);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al insertar el Recurso:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Recurso> consultarRecursos() throws BibliotecaException{
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
            recursoDAO.updateRecurso(id,nuevoEstado);
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
    public Reserva getInfoReserva(int recursoId, Date inicio, Date fin) throws BibliotecaException {
        try {
            return reservaDAO.getInfoReserva(recursoId,inicio,fin);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar las reservas Disponibles:" + ex.getLocalizedMessage(), ex);
        }
    }

    
}
