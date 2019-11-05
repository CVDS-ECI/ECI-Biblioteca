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
                int longitud_lista1=listaAntesDeInsertar.size();
		bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 5,"Disponible"));
                List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
                int longitud_lista2=listaDespuesDeInsertar.size();
		assertTrue(longitud_lista2>longitud_lista1);
    }
    
    @Test
    public void noDeberiaRegistrarRecurso() throws BibliotecaException {
                try{
                    bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", -5,"Disponible"));
                }
                catch(BibliotecaException e){
                    System.out.println(BibliotecaException.RECURSO_INSERTAR);
                }
    }
    
    @Test
    public void deberiaConsultarRecurso() throws BibliotecaException {
		//Recurso recurso = bibliotecaServices.consultarRecurso(21);
		//assertTrue(recurso.getNombre().equals("Sala de estudio 7") && recurso.getUbicacion().equals("Biblioteca G") && recurso.getTipo().equals("Sala") && recurso.getCapacidad()== 6 && recurso.getEstado().equals("Disponible"));
    }
    
    @Test
    public void noDeberiaConsultarRecurso() throws BibliotecaException {
                //Recurso recurso = bibliotecaServices.consultarRecurso(-55);
                //assertTrue(recurso==null);
    }
}
