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
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;
import java.sql.Time;
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
            Time horaInicio = Time.valueOf("10:59:59");
            Time horaFin = Time.valueOf("12:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista1 = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 1, "Disponible",horaInicio,horaFin));
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 > longitud_lista1);
    }
     
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que la capacidad
    tiene que ser mayor a cero. Este caso funciona porque la cantidad es 2
    */
    @Test
    public void deberiaRegistrarRecurso2() throws BibliotecaException {
        Time horaInicio = Time.valueOf("11:59:59");
        Time horaFin = Time.valueOf("13:59:59");
        List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista1 = listaAntesDeInsertar.size();
        bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 2, "Disponible",horaInicio,horaFin));
        List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
        int longitud_lista2 = listaDespuesDeInsertar.size();
        assertTrue(longitud_lista2 > longitud_lista1);
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que la capacidad
    tiene que ser mayor a cero. Este caso no funciona porque la cantidad es -1
    */
    @Test
    public void noDeberiaRegistrarRecurso() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("aljebra2", "Biblioteca JAL Bloque B", "Sala", -1, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que la capacidad
    tiene que ser mayor a cero. Este caso no funciona porque la cantidad es 0
    */
    @Test
    public void noDeberiaRegistrarRecurso2() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 0, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que la capacidad
    tiene que ser mayor a cero. Este caso no funciona porque la cantidad es -2
    */
    @Test
    public void noDeberiaRegistrarRecurso4() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("aljebra", "Biblioteca JAL Bloque B", "Sala", -2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = 'iPhone' para prbar que no se puede
    registar.
    */
    @Test
    public void noDeberiaRegistrarRecurso5() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "iPhone", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = ' ' para prbar que no se puede
    registar.
    */
    @Test
    public void noDeberiaRegistrarRecurso6() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", " ", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = 'Sala'  para probar que se puede
    registar.
    */
    @Test
    public void deberiaRegistrarRecurso7() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Sala", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = 'Equipo de computo'  para probar que se puede
    registar.
    */
    @Test
    public void deberiaRegistrarRecurso8() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Equipo de computo", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = 'Equipo de multimedia'  para probar que se puede
    registar.
    */
    @Test
    public void deberiaRegistrarRecurso9() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Equipo de multimedia", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta los tipos
    existen que son: 'Sala', 'Equipo de computo’, ‘Equipo de multimedia’,
    ‘Libro'. En esta prueba se coloca tipo = 'Libro'  para probar que se puede
    registar.
    */
    @Test
    public void deberiaRegistrarRecurso10() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("Video Bean", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'En Mantenimiento’,
    ‘No Disponible’. Aca se prueba estado= 'D' el cual es incorrecto :
    */
    @Test
    public void noDeberiaRegistrarRecurso11() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "D",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'En Mantenimiento’,
    ‘No Disponible’. Aca se prueba estado= '' el cual es incorrecto :
    */
    @Test
    public void noDeberiaRegistrarRecurso12() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, " ",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'En Mantenimiento’,
    ‘No Disponible’. Aca se prueba estado= 'Disponible' el cual es correcto :
    */
    @Test
    public void deberiaRegistrarRecurso13() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'En Mantenimiento’,
    ‘No Disponible’. Aca se prueba estado= 'En Mantenimiento'' el cual es correcto :
    */
    @Test
    public void deberiaRegistrarRecurso14() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "En Mantenimiento",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'En Mantenimiento’,
    ‘No Disponible’. Aca se prueba estado=  'No Disponible' el cual es correcto :
    */
    @Test
    public void deberiaRegistrarRecurso15() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "No Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta las
    ubicaciones permitidas que ubicacion: 'Biblioteca JAL Bloque B',
    'Biblioteca JAL Bloque G'.
    Aca se coloca ubicacion= 'sala antigua' que es incorrecto :
    */
    @Test
    public void noDeberiaRegistrarRecurso16() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "sala antigua", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta las
    ubicaciones permitidas que ubicacion: 'Biblioteca JAL Bloque B',
    'Biblioteca JAL Bloque G'.
    Aca se coloca ubicacion= ' ' que es incorrecto :
    */
    @Test
    public void noDeberiaRegistrarRecurso17() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", " ", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta las
    ubicaciones permitidas que ubicacion: 'Biblioteca JAL Bloque B',
    'Biblioteca JAL Bloque G'.
    Aca se coloca ubicacion= 'Biblioteca JAL Bloque B' que es correcto :
    */
    @Test
    public void deberiaRegistrarRecurso18() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta las
    ubicaciones permitidas que ubicacion: 'Biblioteca JAL Bloque B',
    'Biblioteca JAL Bloque G'.
    Aca se coloca ubicacion= 'Biblioteca JAL Bloque G'' que es correcto :
    */
    @Test
    public void deberiaRegistrarRecurso19() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    los nombres no sean nulos.'', '  '. Se coloca nombre= '' que es incorrecto:
    */
    @Test
    public void noDeberiaRegistrarRecurso20() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    los nombres no sean nulos.'', '  '. Se coloca nombre= ' ' que es incorrecto:
    */
    @Test
    public void noDeberiaRegistrarRecurso21() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso(" ", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    los nombres no sean nulos.'', '  '. Se coloca nombre= 'fisica 8' que es correcto:
    */
    @Test
    public void deberiaRegistrarRecurso22() throws BibliotecaException {
        try {
            Time horaInicio = Time.valueOf("11:59:59");
            Time horaFin = Time.valueOf("13:59:59");
            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();
            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();
            bibliotecaServices.registrarRecurso(new Recurso("fisica 8", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible",horaInicio,horaFin));
        } catch (BibliotecaException e) {
            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();
            int longitud_lista2 = listaDespuesDeInsertar.size();
            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);
            System.out.println(BibliotecaException.RECURSO_INSERTAR);
        }
    }
    
    /*
    Cuando se quiere consultar un recurso, se debe tener en cuenta que el id exista
    en este caso se coloca un id=2 que es correcto para que me de un 
    recurso no nulo
    */
    @Test
    public void deberiaConsultarRecurso() throws BibliotecaException {
        Recurso recurso = bibliotecaServices.consultarRecurso(283);
        Time horaInicio = Time.valueOf("11:59:59");
        Time horaFin = Time.valueOf("13:59:59");
        assertTrue(recurso.getNombre().equals("fisica 8") && recurso.getUbicacion().equals("Biblioteca JAL Bloque G") && recurso.getTipo().equals("Sala") && recurso.getCapacidad() == 6 && recurso.getEstado().equals("Disponible") && recurso.getHoraInicio().equals(horaInicio) && recurso.getHoraFin().equals(horaFin) );
    }
    
    /*
    Cuando se quiere consultar las listas de recursos puede tener cero recursos
    */
    @Test
    public void deberiaConsultarRecursos() throws BibliotecaException {
        List<Recurso> recursos = bibliotecaServices.consultarRecursos();
        assertTrue(recursos.size()>=0);
    }
    
    /*
    Cuando se quiere consultar un recurso, se debe tener en cuenta que el id exista
    en este caso se coloca un id=-154 que es incorrecto para que me de un 
    recurso nulo
    */
    @Test
    public void noDeberiaConsultarRecurso() throws BibliotecaException {
        Recurso recurso = bibliotecaServices.consultarRecurso(-154);
        assertTrue(recurso==null);
    }
    
    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta 
    que los estados permitidos son :'Disponible', 'En Mantenimiento’,
    ‘No Disponible' y el id exista.No se puede modificar con este caso
    Id =-1 estado= 'D':
    */
    @Test
    public void noDeberiaModificarRecurso() throws BibliotecaException {
        try {
            bibliotecaServices.updateRecurso(-1, "D");
            numeroDespuesModificar=-1;
        }
        catch(BibliotecaException e){
            assertTrue(numeroDespuesModificar!=-1);
            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);
        }
    }
    
    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta 
    que los estados permitidos son :'Disponible', 'En Mantenimiento’,
    ‘No Disponible' y el id exista.No se puede modificar con este caso
    Id =302 estado= '':
    */
    @Test
    public void noDeberiaModificarRecurso2() throws BibliotecaException {
        try {
            bibliotecaServices.updateRecurso(302, "");
            numeroDespuesModificar=-1;
        }
        catch(BibliotecaException e){
            assertTrue(numeroDespuesModificar!=-1);
            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);
        }
    }
    
    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta 
    que los estados permitidos son :'Disponible', 'En Mantenimiento’,
    ‘No Disponible' y el id exista.Se puede modificar con este caso
    Id = 302 estado= 'Disponible'  :
    */
    @Test
    public void deberiaModificarRecurso() throws BibliotecaException {
        try {
            bibliotecaServices.updateRecurso(302, "Disponible");
            numeroDespuesModificar=-1;
        }
        catch(BibliotecaException e){
            assertTrue(numeroDespuesModificar==-1);
            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);
        }
    }
    
    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta 
    que los estados permitidos son :'Disponible', 'En Mantenimiento’,
    ‘No Disponible' y el id exista.Se puede modificar con este caso
    Id = 302 estado= 'En Mantenimiento'  :
    */
    @Test
    public void deberiaModificarRecurso2() throws BibliotecaException {
        try {
            bibliotecaServices.updateRecurso(302, "En Mantenimiento");
            numeroDespuesModificar=-1;
        }
        catch(BibliotecaException e){
            assertTrue(numeroDespuesModificar==-1);
            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);
        }
    }
    
    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta 
    que los estados permitidos son :'Disponible', 'En Mantenimiento’,
    ‘No Disponible' y el id exista.Se puede modificar con este caso
    Id = 302 estado= 'No Disponible'  :
    */
    @Test
    public void deberiaModificarRecurso3() throws BibliotecaException {
        try {
            bibliotecaServices.updateRecurso(302, "No Disponible");
            numeroDespuesModificar=-1;
        }
        catch(BibliotecaException e){
            assertTrue(numeroDespuesModificar==-1);
            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);
        }
    }
}
