package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import java.util.List;

public class MyBatisRecursoDAO implements RecursoDAO{
    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void addRecurso(Recurso recurso) throws PersistenceException {
	try{
             recursoMapper.addRecurso(recurso);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             
             throw new PersistenceException("Error al registrar recurso: "+recurso.getNombre(), e);
             
         }	
    }

    @Override
    public List<Recurso> loadRecursos() throws PersistenceException {
        List<Recurso> recursos = null;
        try{
             recursos = recursoMapper.consultarRecursos();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar recursos ", e);   
         }  
        return recursos;
    }

    @Override
    public void updateRecurso(int recurso, String nuevoEstado) throws PersistenceException {
        try{
             recursoMapper.updateRecurso(recurso,nuevoEstado);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al Actualizar el estado del recurso", e);
             
         }
    }
    
    @Override
    public Recurso loadRecurso(int id) throws PersistenceException {
         Recurso recurso=null;
         try{
             recurso = recursoMapper.consultarRecurso(id);
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el recurso con el id: "+id, e);
             
         }
         return recurso;
        
    }

    @Override
    public List<Recurso> loadRecursosDisponibles() throws PersistenceException {
        List<Recurso> recursos = null;
        try{
             recursos = recursoMapper.consultarRecursosDisponibles();
         }
         catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar recursos disponibles", e);   
         }  
        return recursos;
    }

}

    