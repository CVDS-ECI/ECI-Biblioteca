package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import java.util.List;

public interface RecursoDAO  {
	public void addRecurso(Recurso recurso) throws PersistenceException;
        public List<Recurso> loadRecursos() throws PersistenceException;
        public void updateRecurso(Long recurso, String nuevoEstado) throws PersistenceException;
        public Recurso loadRecurso(int id) throws PersistenceException;
}
