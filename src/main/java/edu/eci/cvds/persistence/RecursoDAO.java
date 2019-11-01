package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import java.util.List;

public interface RecursoDAO  {
	public void addRecurso(int computerId) throws PersistenceException;
        public List<Recurso> loadRecursos() throws PersistenceException;
}
