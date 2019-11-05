package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;
import java.util.List;


public interface BibliotecaServices {

	public void registrarRecurso(Recurso rec) throws BibliotecaException;
        
        public List<Recurso> consultarRecursos()throws BibliotecaException;
        
        public Recurso consultarRecurso(int id) throws BibliotecaException;
        
        public void updateRecurso(Long id, String nuevoEstado) throws BibliotecaException;
        
        

}
