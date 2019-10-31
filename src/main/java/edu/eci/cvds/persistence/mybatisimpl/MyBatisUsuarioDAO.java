
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 2145120
 */
public class MyBatisUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    /*
    @Override
    public void save(Usuario cl) throws PersistenceException {
        try {
        	usuarioMapper.agregarCliente(cl);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar el cliente en MyBatisClienteDAO " + cl.toString(), e);
        }

    }
   
    @Override
    public List<Usuario> consultarClientes() throws PersistenceException {
        try {
            return usuarioMapper.consultarClientes();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los clientes ", e);
        }

    }
    
    @Override
    public List<ItemRentado> loadItemsRentados(long id) throws PersistenceException {
        try {
            return usuarioMapper.consultarItemsRentados(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los items Rentados del cliente " + id, e);
        }
    }

    @Override
    public void addItemRentado(long id, int iditem, Date fechainicio, Date fechafin) throws PersistenceException {
        try {
        	usuarioMapper.agregarItemRentadoACliente(id,iditem,fechainicio,fechafin);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los items Rentados del cliente " + id, e);
        }
    }
	*/

	
}
