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
		//bibliotecaServices.registrarRecurso(new Recurso("fisica 2", "seccion B", "libro", 1,"D"));
		//Recurso recurso = bibliotecaServices.consultarRecurso(1);
		//assertTrue(recurso!=null && recurso.getId()==1);
    }
}
