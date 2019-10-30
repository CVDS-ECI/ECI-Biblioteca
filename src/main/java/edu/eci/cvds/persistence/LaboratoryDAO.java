package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Laboratory;

public interface LaboratoryDAO {
	
    public void save(Laboratory user) throws PersistenceException;

	public List<Laboratory> loadAll() throws PersistenceException;
	
}
