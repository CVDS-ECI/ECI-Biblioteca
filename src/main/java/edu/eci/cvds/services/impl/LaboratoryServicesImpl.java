/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Computer;
import edu.eci.cvds.entities.Element;
import edu.eci.cvds.entities.Laboratory;
import edu.eci.cvds.persistence.ComputerDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.LaboratoryDAO;
import edu.eci.cvds.services.LaboratoryServices;
import edu.eci.cvds.services.BibliotecaException;

import java.util.List;

public class LaboratoryServicesImpl implements LaboratoryServices {

    @Inject
    private LaboratoryDAO laboratoryDAO;

    @Inject
    private ComputerDAO computerDAO;

    @Override
    public void createLaboratory(Laboratory laboratory) throws BibliotecaException {
        try {
            laboratoryDAO.save(laboratory);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Create laboratory error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Laboratory> listLaboratories() throws BibliotecaException {
        try {
            return laboratoryDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Load laboratories error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Computer> listComputers() throws BibliotecaException {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Computer> searchByLaboratory(String laboratory) throws BibliotecaException {
        try {
            return computerDAO.loadByLaboratory(laboratory);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Search computer error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Element> searchElementsByComputerReference(String reference) throws BibliotecaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Element> buscarElementosAsociadosAUnComputador(int cId) throws BibliotecaException {
        try {
            return computerDAO.loadAssociatedElements(cId);
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar los elementos de un equipo:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Computer> searchIncompleteComputers() throws BibliotecaException {
                try {
            return computerDAO.searchIncompleteComputers();
        } catch (PersistenceException ex) {
            throw new BibliotecaException("Error al consultar los elementos de un equipo:" + ex.getLocalizedMessage(), ex);
        }
    }

}
