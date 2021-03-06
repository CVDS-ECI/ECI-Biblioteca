/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoReserva;
import edu.eci.cvds.managedbeans.ReservaBean;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.BibliotecaServicesFactory;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import edu.eci.cvds.managedbeans.*;
import static org.junit.Assert.assertTrue;

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

        bibliotecaServices.registrarRecurso(new Recurso("Calentamiento global", "Biblioteca JAL Bloque B", "Libro", 1, "Disponible", horaInicio, horaFin));

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

        bibliotecaServices.registrarRecurso(new Recurso("Control de procesos industriales", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Programacion 1", "Biblioteca JAL Bloque B", "Libro", -1, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Tsor 2", "Biblioteca JAL Bloque B", "Sala", 0, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("aljebra", "Biblioteca JAL Bloque B", "Sala", -2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Video beam", "Biblioteca JAL Bloque B", " ", 2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Control de procesos industriales", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Aprendiendo a programar", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Autocad", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Algebra de baldor", "Biblioteca JAL Bloque B", "Libro", 2, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'Mantenimiento’,
    ‘NoDisponible’. Aca se prueba estado= 'D' el cual es incorrecto :
     */
    @Test

    public void noDeberiaRegistrarRecurso11() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("11:59:59");

            Time horaFin = Time.valueOf("13:59:59");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, "D", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'Mantenimiento’,
    ‘NoDisponible’. Aca se prueba estado= '' el cual es incorrecto :
     */
    @Test

    public void noDeberiaRegistrarRecurso12() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("11:59:59");

            Time horaFin = Time.valueOf("13:59:59");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", "Biblioteca JAL Bloque B", "Sala", 6, " ", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'Mantenimiento’,
    ‘NoDisponible’. Aca se prueba estado= 'Disponible' el cual es correcto :
     */
    @Test

    public void deberiaRegistrarRecurso13() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("11:59:59");

            Time horaFin = Time.valueOf("13:59:59");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("Video Beam", "Biblioteca JAL Bloque B", "Equipo de computo", 6, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'Mantenimiento’,
    ‘NoDisponible’. Aca se prueba estado= 'Mantenimiento'' el cual es correcto :
     */
    @Test

    public void deberiaRegistrarRecurso14() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("11:59:59");

            Time horaFin = Time.valueOf("13:59:59");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("Sala 2", "Biblioteca JAL Bloque B", "Sala", 6, "Mantenimiento", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que estados
    hay para disponibilidad los cuales son: 'Disponible', 'Mantenimiento’,
    ‘NoDisponible’. Aca se prueba estado=  'NoDisponible' el cual es correcto :
     */
    @Test

    public void deberiaRegistrarRecurso15() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("11:59:59");

            Time horaFin = Time.valueOf("13:59:59");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("Portatil", "Biblioteca JAL Bloque B", "Equipo de computo", 6, "NoDisponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Calculo de una variable", "sala antigua", "Libro", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("fisica 4", " ", "Sala", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Cálculo de varias variables", "Biblioteca JAL Bloque B", "Libro", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("Sala 2", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso(" ", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

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

            bibliotecaServices.registrarRecurso(new Recurso("fisica 8", "Biblioteca JAL Bloque G", "Libro", 6, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println(BibliotecaException.RECURSO_INSERTAR);

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    que el inicio reserva < fin reserva. Se coloca Inicioreserva=’12:00:00’, finreserva=’13:00:00’ que es correcto:
     */
    @Test

    public void deberiaRegistrarReserva() throws BibliotecaException, ParseException {

        Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 08:00:00");

        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 06:00:00");

        Date date3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 06:00:00");

        Date date4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/13/04 06:00:00");

        Reserva reserva = new Reserva("rubiano", 3128, "Geogebra desde cero", date3, date1, date2, false, TipoReserva.Diario, EstadoReserva.EnCurso, date4);

        bibliotecaServices.registrarReserva(reserva);

        assertTrue(reserva.getTitulo() == "Geogebra desde cero");

    }

    @Test

    public void deberiaRegistrarReserva2() throws BibliotecaException, ParseException {

        Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 08:00:00");

        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 07:00:00");

        Date date3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 07:00:00");

        Date date4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/13/04 07:00:00");

        Reserva reserva = new Reserva("rubiano", 3417, "Sala 7", date3, date1, date2, false, TipoReserva.Ninguno, EstadoReserva.EnCurso, date4);

        bibliotecaServices.registrarReserva(reserva);

        assertTrue(reserva.getTitulo() == "Sala 7");

    }

    @Test

    public void deberiaRegistrarReserva3() throws BibliotecaException, ParseException {

        Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 09:00:00");

        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 08:00:00");

        Date date3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 08:00:00");

        Date date4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/13/04 08:00:00");

        Reserva reserva = new Reserva("rubiano", 3268, "PC", date3, date1, date2, false, TipoReserva.Semanal, EstadoReserva.EnCurso, date4);

        bibliotecaServices.registrarReserva(reserva);

        assertTrue(reserva.getTitulo() == "PC");

    }

    @Test

    public void deberiaRegistrarReserva4() throws BibliotecaException, ParseException {

        Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 11:00:00");

        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 10:00:00");

        Date date3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/12/03 10:00:00");

        Date date4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2019/13/04 10:00:00");

        Reserva reserva = new Reserva("rubiano", 4835, "Autocard", date3, date1, date2, false, TipoReserva.Mensual, EstadoReserva.EnCurso, date4);

        bibliotecaServices.registrarReserva(reserva);

        assertTrue(reserva.getTitulo() == "Autocard");

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
   que el inicio reserva < fin reserva. Se coloca Inicioreserva=’13:00:00’, finreserva=’13:00:00’ que es incorrecto:
     */
    @Test

    public void noDeberiaRegistrarRecurso24() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("13:00:00");

            Time horaFin = Time.valueOf("13:00:00");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("fisica 8", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println("horaInicio>=horaFin");

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    que el inicio reserva < fin reserva. Se coloca Inicioreserva=’14:00:00’, finreserva=’13:00:00’ que es incorrecto:
     */
    @Test

    public void noDeberiaRegistrarRecurso25() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("14:00:00");

            Time horaFin = Time.valueOf("13:00:00");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("fisica 8", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println("horaInicio>=horaFin");

        }

    }

    /*
    Cuando se quiere registrar un recurso se debe tener en cuenta que
    que el inicio reserva < fin reserva. Se coloca Inicioreserva=’14:00:00’, finreserva=’13:00:00’ que es incorrecto:
     */
    @Test

    public void noDeberiaRegistrarRecurso26() throws BibliotecaException {

        try {

            Time horaInicio = Time.valueOf("15:00:00");

            Time horaFin = Time.valueOf("12:00:00");

            List<Recurso> listaAntesDeInsertar = bibliotecaServices.consultarRecursos();

            longitudListaAntesDeInsertar = listaAntesDeInsertar.size();

            bibliotecaServices.registrarRecurso(new Recurso("fisica 8", "Biblioteca JAL Bloque G", "Sala", 6, "Disponible", horaInicio, horaFin));

        } catch (BibliotecaException e) {

            List<Recurso> listaDespuesDeInsertar = bibliotecaServices.consultarRecursos();

            int longitud_lista2 = listaDespuesDeInsertar.size();

            assertTrue(longitud_lista2 == longitudListaAntesDeInsertar);

            System.out.println("horaInicio>=horaFin");

        }

    }

    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta
    que los estados permitidos son :'Disponible', 'Mantenimiento’,
    ‘NoDisponible' y el id exista.No se puede modificar con este caso
    Id =-1 estado= 'D':
     */
    @Test

    public void noDeberiaModificarRecurso() throws BibliotecaException {

        try {

            bibliotecaServices.updateRecurso(-1, "D");

            numeroDespuesModificar = -1;

        } catch (BibliotecaException e) {

            assertTrue(numeroDespuesModificar != -1);

            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);

        }

    }

    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta
    que los estados permitidos son :'Disponible', 'Mantenimiento’,
    ‘NoDisponible' y el id exista.No se puede modificar con este caso
    Id =302 estado= '':
     */
    @Test

    public void noDeberiaModificarRecurso2() throws BibliotecaException {

        try {

            bibliotecaServices.updateRecurso(302, "");

            numeroDespuesModificar = -1;

        } catch (BibliotecaException e) {

            assertTrue(numeroDespuesModificar != -1);

            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);

        }

    }

    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta
    que los estados permitidos son :'Disponible', 'Mantenimiento’,
    ‘NoDisponible' y el id exista.Se puede modificar con este caso
    con  estado= 'Disponible'  :
     */
    @Test

    public void deberiaModificarRecurso() throws BibliotecaException {

        try {

            bibliotecaServices.updateRecurso(3398, "Disponible");

            numeroDespuesModificar = -1;

        } catch (BibliotecaException e) {

            assertTrue(numeroDespuesModificar == -1);

            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);

        }

    }

    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta
    que los estados permitidos son :'Disponible', 'Mantenimiento’,
    ‘NoDisponible' y el id exista.Se puede modificar con este caso
    Id = 3398 estado= 'Mantenimiento'  :
     */
    @Test

    public void deberiaModificarRecurso2() throws BibliotecaException {

        try {

            bibliotecaServices.updateRecurso(3398, "Mantenimiento");

            numeroDespuesModificar = -1;

        } catch (BibliotecaException e) {

            assertTrue(numeroDespuesModificar == -1);

            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);

        }

    }

    /*
    Cuando se quiere modificar un recurso, se debe tener en cuenta
    que los estados permitidos son :'Disponible', 'Mantenimiento’,
    ‘NoDisponible' y el id exista.Se puede modificar con este caso
    Id = 3398 estado= 'NoDisponible'  :
     */
    @Test

    public void deberiaModificarRecurso3() throws BibliotecaException {

        try {

            bibliotecaServices.updateRecurso(3398, "NoDisponible");

            numeroDespuesModificar = -1;

        } catch (BibliotecaException e) {

            assertTrue(numeroDespuesModificar == -1);

            System.out.println(BibliotecaException.RECURSO_NO_EXISTE);

        }

    }

    /*
    Cuando se quiere consultar las listas de recursos puede tener cero recursos
     */
    @Test

    public void deberiaConsultarRecursosDisponibles() throws BibliotecaException {

        List<Recurso> recursos = bibliotecaServices.consultarRecursosDisponibles();

        if (recursos.size() > 0) {

            Recurso recurso = recursos.get(0);

            assertTrue(recurso.getEstado().equals("Disponible"));

        }

        assertTrue(recursos.size() >= 0);

    }
}
