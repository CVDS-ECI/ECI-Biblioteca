/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;


import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaException;

import java.util.List;

public class BibliotecaServicesImpl implements BibliotecaServices {

    @Inject
    UsuarioDAO usuarioDAO;

    @Inject
    RecursoDAO recursoDAO;

    
}
