/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaServicesFactory;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 * @author davidleon
 */
@Transactional
public class ServicesBibliotecaTest {
    
    private BibliotecaServices bibliotecaServices;
    
    public ServicesBibliotecaTest() {
        bibliotecaServices = BibliotecaServicesFactory.getInstance().getBlogServices();
    }
    
    @Test
    public void deberiaRegistrarRecurso() throws BibliotecaException {
        List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista1 = listaAntesDeInsertar.size();
        bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 5, "Disponible"));
        List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista2 = listaDespuesDeInsertar.size();
        assertTrue(longitud_lista2 > longitud_lista1);
    }
    
    @Test
    public void deberiaRegistrarRecurso2() throws BibliotecaException {
        List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista1 = listaAntesDeInsertar.size();
        bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 1, "Disponible"));
        List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista2 = listaDespuesDeInsertar.size();
        assertTrue(longitud_lista2 > longitud_lista1);
    }
    
    @Test
    public void noDeberiaRegistrarRecurso() throws BibliotecaException {
        try {
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", -5, "Disponible"));
        } catch (BibliotecaException e) {
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    @Test
    public void noDeberiaRegistrarRecurso2() throws BibliotecaException {
        try {
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 0, "Disponible"));
        } catch (BibliotecaException e) {
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    @Test
    public void noDeberiaRegistrarRecurso3() throws BibliotecaException {
        try {
            bibliotecaServices.registrarRecurso(new Recurso(" ", "Biblioteca JAL Bloque B", "Sala", 6, "Disponible"));
        } catch (BibliotecaException e) {
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    @Test
    public void noDeberiaRegistrarRecurso4() throws BibliotecaException {
        try {
            bibliotecaServices.registrarRecurso(new Recurso("libro", "Biblioteca JAL Bloque B", "Sala", 7, "no existe"));
        } catch (BibliotecaException e) {
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    @Test
    public void deberiaConsultarRecurso() throws BibliotecaException {
        //Recurso recurso = bibliotecaServices.consultarRecurso(154);
        //assertTrue(recurso.getNombre().equals("Video Bean") && recurso.getUbicacion().equals("Biblioteca JAL Bloque B") && recurso.getTipo().equals("Sala") && recurso.getCapacidad() == 5 && recurso.getEstado().equals("Disponible"));
    }
    
    @Test
    public void deberiaConsultarRecursos() throws BibliotecaException {
        List<Recurso> recursos = bibliotecaServices.consultarRecursos();
        assertTrue(recursos.size()>0);
    }
    
    @Test
    public void noDeberiaConsultarRecurso() throws BibliotecaException {
        Recurso recurso = bibliotecaServices.consultarRecurso(-154);
        assertTrue(recurso==null);
    }
}