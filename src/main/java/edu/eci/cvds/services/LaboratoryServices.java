package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Computer;
import edu.eci.cvds.entities.Element;
import edu.eci.cvds.entities.Laboratory;

public interface LaboratoryServices {

	/**
	 * Create laboratory
	 * 
	 * @param laboratory the laboratory to create
	 * @throws ServicesException
	 */
	public void createLaboratory(Laboratory laboratory) throws ServicesException;

	/**
	 * List all available laboratories
	 * 
	 * @return a list of laboratories found
	 * @throws ServicesException
	 */
	public List<Laboratory> listLaboratories() throws ServicesException;

	/**
	 * List all available computers
	 * 
	 * @return a list of computers found
	 * @throws ServicesException
	 */
	public List<Computer> listComputers() throws ServicesException;

	/**
	 * List all computers based on a laboratory's name
	 * 
	 * @param laboratory the laboratory's name
	 * @return a list of computers found
	 * @throws ServicesException
	 */
	public List<Computer> searchByLaboratory(String laboratory) throws ServicesException;

	/**
	 * Find all elements based on a computer's reference
	 * 
	 * @param reference the computer's reference
	 * @return a list of elements found
	 * @throws ServicesException
	 */
	public List<Element> searchElementsByComputerReference(String reference) throws ServicesException;

	/**
	 * Find all computers that are incomplete
	 * 
	 * @return a list of incomplete computers
	 * @throws ServicesException
	 */
	public List<Computer> searchIncompleteComputers() throws ServicesException;
        
        public List<Element> buscarElementosAsociadosAUnComputador(int cId) throws ServicesException;

}
