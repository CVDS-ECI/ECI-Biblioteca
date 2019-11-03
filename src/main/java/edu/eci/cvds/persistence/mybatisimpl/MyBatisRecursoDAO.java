package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

public class MyBatisRecursoDAO implements RecursoDAO{
    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void addRecurso(int computerId) throws PersistenceException {
		// TODO Auto-generated method stub
		
    }

    @Override
    public List<Recurso> loadRecursos() throws PersistenceException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recurso loadRecurso(int id) throws PersistenceException {
         Recurso recurso=null;
         try{
             recurso = recursoMapper.consultarRecurso(id);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el recurso con el id;", e);
             
         }
         return recurso;
        
    }
}
