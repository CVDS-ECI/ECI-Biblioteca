/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;


import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaException;

import java.util.List;

public class BibliotecaServicesImpl implements BibliotecaServices {

    @Inject
    UsuarioDAO usuarioDAO;
    RecursoDAO recursoDAO;

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

    
}
