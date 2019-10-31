package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Element;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBatisRecursoDAO implements RecursoDAO{
	@Inject
    private RecursoMapper recursoMapper;

	@Override
	public void addRecurso(int computerId, Element element) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
}
