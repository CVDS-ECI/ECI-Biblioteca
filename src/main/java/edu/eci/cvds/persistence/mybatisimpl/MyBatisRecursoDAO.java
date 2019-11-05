package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

public class MyBatisRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void addRecurso(Recurso recurso) throws PersistenceException {
        try {
            recursoMapper.addRecurso(recurso);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al registrar recurso: " + recurso.getNombre(), e);

        }
    }

    @Override
    public List<Recurso> loadRecursos() throws PersistenceException {
        List<Recurso> recursos = null;
        try {
            recursos = recursoMapper.consultarRecursos();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar recursos ", e);
        }
        return recursos;
    }

    @Override
    public Recurso loadRecurso(int id) throws PersistenceException {
        Recurso recurso = null;
        try {
            recurso = recursoMapper.consultarRecurso(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar el recurso con el id: " + id, e);

        }
        return recurso;

    }

    @Override
    public void modificarEstadoRecurso(int id, String estadoNuevo) throws PersistenceException {
        try {
            int idRecurso = recursoMapper.modificarEstadoRecurso(id, estadoNuevo);
            if (idRecurso == 0) {
                throw new PersistenceException("El recurso ingresado no existe");
            }
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar el recurso con el id: "+id+" para ser modificado su estado", e);
        }
    }
}
