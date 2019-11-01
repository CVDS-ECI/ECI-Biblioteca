/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 2145120
 */
public interface UsuarioDAO {

    public void addUsuario(Usuario cl) throws PersistenceException;
    public List<Usuario> loadUsuarios() throws PersistenceException;
}