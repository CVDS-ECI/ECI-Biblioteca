package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Laboratory;
import edu.eci.cvds.persistence.LaboratoryDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.LaboratoryMapper;


public class MyBatisLaboratoryDAO implements LaboratoryDAO {

	@Inject
	LaboratoryMapper laboratoryMapper;
	
	@Override
	public List<Laboratory> loadAll() throws PersistenceException {
		try {
			return laboratoryMapper.getLaboratories();			
		} catch(Exception e) {
			throw new PersistenceException("Load all persistence error", e);
		}
	}

	@Override
	public void save(Laboratory laboratory) throws PersistenceException {
		try {
			laboratoryMapper.insertLaboratory(laboratory);			
		} catch(Exception e) {
			throw new PersistenceException("Load all persistence error", e);
		}
	}
	

}
