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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private int longitudListaAntesDeInsertar;
    private int numeroDespuesModificar;
    
    public ServicesBibliotecaTest() {
        bibliotecaServices = BibliotecaServicesFactory.getInstance().getBlogServices();
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que la capacidad
    tiene que ser mayor a cero. Este caso funciona porque la cantidad es 1
    */
    @Test
    public void deberiaRegistrarRecurso() throws BibliotecaException {
        
            java.sql.Timestamp sqlTS = java.sql.Timestamp.valueOf("1997-05-07 21:30:55");
            //List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            //int longitud_lista1 = listaAntesDeInsertar.size();
            //Date date = new Date();  
            //Timestamp sqlTS=new Timestamp(date.getTime());
            //System.out.println(listaAntesDeInsertar);
            //System.out.println(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 1, "Disponible",sqlTS,sqlTS));
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 1, "Disponible",sqlTS,sqlTS));
            //List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            //int longitud_lista2 = listaDespuesDeInsertar.size();
            //assertTrue(longitud_lista2 > longitud_lista1);
       
    }
    
    
}
