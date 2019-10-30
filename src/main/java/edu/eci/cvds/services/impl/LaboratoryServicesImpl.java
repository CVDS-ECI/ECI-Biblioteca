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
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class LaboratoryServicesImpl implements LaboratoryServices {

    @Inject
    private LaboratoryDAO laboratoryDAO;

    @Inject
    private ComputerDAO computerDAO;

    @Override
    public void createLaboratory(Laboratory laboratory) throws ServicesException {
        try {
            laboratoryDAO.save(laboratory);
        } catch (PersistenceException ex) {
            throw new ServicesException("Create laboratory error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Laboratory> listLaboratories() throws ServicesException {
        try {
            return laboratoryDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ServicesException("Load laboratories error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Computer> listComputers() throws ServicesException {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Computer> searchByLaboratory(String laboratory) throws ServicesException {
        try {
            return computerDAO.loadByLaboratory(laboratory);
        } catch (PersistenceException ex) {
            throw new ServicesException("Search computer error:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Element> searchElementsByComputerReference(String reference) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Element> buscarElementosAsociadosAUnComputador(int cId) throws ServicesException {
        try {
            return computerDAO.loadAssociatedElements(cId);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al consultar los elementos de un equipo:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Computer> searchIncompleteComputers() throws ServicesException {
                try {
            return computerDAO.searchIncompleteComputers();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al consultar los elementos de un equipo:" + ex.getLocalizedMessage(), ex);
        }
    }

}
