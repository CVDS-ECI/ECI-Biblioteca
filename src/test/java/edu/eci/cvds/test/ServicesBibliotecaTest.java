/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaServicesFactory;
import static org.junit.Assert.assertTrue;
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
		bibliotecaServices.registrarRecurso(new Recurso("sala de estudio 3", "biblioteca A", "sala", 5,"Disponible"));
		Recurso recurso = bibliotecaServices.consultarRecurso(29);
		assertTrue(recurso.getId()==29);
    }
    
    @Test
    public void deberiaConsultarRecurso() throws BibliotecaException {
		Recurso recurso = bibliotecaServices.consultarRecurso(21);
		assertTrue(recurso.getNombre().equals("Sala de estudio 7") && recurso.getUbicacion().equals("Biblioteca G") && recurso.getTipo().equals("Sala") && recurso.getCapacidad()== 6 && recurso.getEstado().equals("Disponible"));
    }
}
