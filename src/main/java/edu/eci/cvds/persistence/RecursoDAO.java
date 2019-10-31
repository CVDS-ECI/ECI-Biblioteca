package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Element;

public interface RecursoDAO  {
	public void addRecurso(int computerId, Element element) throws PersistenceException;
}
