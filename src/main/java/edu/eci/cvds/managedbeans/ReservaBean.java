/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.CustomScheduleEvent;
import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoReserva;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import static org.primefaces.behavior.validate.ClientValidator.PropertyKeys.event;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 * @author Ing Marcelo
 */
@ManagedBean(name = "reservaBean", eager = true)
@SessionScoped
public class ReservaBean extends BasePageBean implements Serializable {

    //    @ManagedProperty(value = "#{param.recursoID}")
    private int recursoID = 0;
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private BibliotecaServices serviciosBiblioteca;

    private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent event = new DefaultScheduleEvent();
    private ScheduleEvent eventAux = new DefaultScheduleEvent();
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private TipoReserva frecuencia;
    private String duracion;
    private String fretiempo;
    private Reserva reserva;
    private Date nextDate;
    private Reserva resssss;
    private String usuario;

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public int getRecursoID() {
        return recursoID;
    }

    public void setRecursoID(int recursoID) {
        this.recursoID = recursoID;
    }

    public TipoReserva getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(TipoReserva frecuencia) {
        this.frecuencia = frecuencia;
    }

    private int datee;

    public TipoReserva[] getTipos() {
        return TipoReserva.values();
    }

    public int getDatee() {
        return datee;
    }

    public void setDatee(int datee) {
        this.datee = datee;
    }

    public Date calcularSiguienteAparicion(TipoReserva tipo, Date fecha, int frecuencia) {
        if (frecuencia != 1) {
            return sumaFecha(fecha, tipo);
        } else {
            return obtenerR().getDataInicio();
        }
    }

    private boolean validarInsercionFechas(Date start, Date end, int idrecurso) throws BibliotecaException {
        //Falta pensar si la horafin es menor
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(idrecurso);
        //Mouseky herramienta misteriosa x2
        if (!reservas.stream().noneMatch((res) -> ((start.equals(res.getDataInicio()) && end.equals(res.getDataFim())) //Caso 
                || (start.after(res.getDataInicio()) && end.before(res.getDataFim()))
                || (start.after(res.getDataInicio()) && start.before(res.getDataFim()))
                || (end.after(res.getDataInicio()) && end.before(res.getDataFim()))))) {
            return false;
        }
        return true;
    }

    private Date sumaFecha(Date fecha, TipoReserva res) {
        dateFormat.format(fecha);
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        switch (res) {
            case Ninguno:
                c.add(Calendar.HOUR, 1);
                break;
            case Diario:
                c.add(Calendar.DATE, 1);
                break;
            case Semanal:
                c.add(Calendar.DATE, 7);
                break;
            case Mensual:
                c.add(Calendar.MONTH, 1);
                break;
        }
        Date result = c.getTime();
        dateFormat.format(result);
        return result;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", sumaFecha((Date) selectEvent.getObject(), TipoReserva.Diario), sumaFecha((Date) selectEvent.getObject(), TipoReserva.Diario));
        eventAux = new DefaultScheduleEvent("", sumaFecha((Date) selectEvent.getObject(), TipoReserva.Diario), sumaFecha((Date) selectEvent.getObject(), TipoReserva.Diario));

    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public void deleteEvent() {
        eventModel.deleteEvent(event);
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;

    }

    public ScheduleEvent getEvent() {
        return event;

    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
        this.eventAux = event;
    }

    public void addEvent(String usuario) throws BibliotecaException {
        if (event.getId() == null) {
            //addEvent(String Usuario, int idRecurso,TipoReserva res, int Duracion)
            /* En esta linea se deben llamar al metodo recursion,con los parametros especificados
            es decir addEvent tambien deberia tener tipoReserva y Duracion todo depende de los campos 
            que los de vista deben hacer :V
             */

            int numero = Integer.parseInt(fretiempo);
            recursion(usuario, recursoID, frecuencia, numero);
        } else {
            eventModel.updateEvent(event);
        }
        event = new DefaultScheduleEvent();
        eventAux = new DefaultScheduleEvent();
    }

    public void recursion(String usuario, int idRecurso, TipoReserva res, int veces) throws BibliotecaException {
        Date dateActual = new Date();
        Date dateActual2 = new Date();
        Date nextDate;
        Date start = event.getStartDate();
        Date end = event.getStartDate();

        ArrayList<Date> reservasSolapadas = new ArrayList();
        if (duracion.equals("1 hora")) {
            end = sumaFecha(end, TipoReserva.Ninguno);

        } else if (duracion.equals("2 horas")) {
            end = sumaFecha(end, TipoReserva.Ninguno);
            end = sumaFecha(end, TipoReserva.Ninguno);

        }
        if (event.getStartDate().after(dateActual2)) {
            if (validarInsercionFechas(event.getStartDate(), end, idRecurso)) {
                serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, usuario + event.getTitle(), dateActual, start, end, false, this.frecuencia, EstadoReserva.EnCurso, event.getStartDate()));
            } else {
                reservasSolapadas.add(event.getStartDate());
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tu(s) reserva(s) estan siendo creadas antes de hoy", null);
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }

        for (int i = 1; i < veces; i++) {
            start = sumaFecha(start, this.frecuencia);
            end = sumaFecha(end, this.frecuencia);
            if (validarInsercionFechas(start, end, idRecurso)) {
                nextDate = (i == (veces - 1)) ? start : sumaFecha(start, res);
                serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, usuario + event.getTitle(), dateActual, start, end, false, this.frecuencia, EstadoReserva.EnCurso, nextDate));
            } else {
                reservasSolapadas.add(start);
            }
        }

        if (reservasSolapadas.size() > 0) {
            String fechas = "";
            //Mouseky herramienta misteriosa 3
            fechas = reservasSolapadas.stream().map((fecha) -> fecha + " \n").reduce(fechas, String::concat);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tu(s) reserva(s) Se solaparon en las siguientes Fechas:  \n  ¡Recarga tu pagina, ¡Por favor!", fechas);

            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su reserva se ha registrado satisfactoriamente \n ¡Recarga tu pagina, ¡Por favor!", null);
            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public String getCarreraU() throws BibliotecaException {
        try {
            Reserva r = obtenerR();
            String j = r.getUsuario();
            String c = serviciosBiblioteca.consultarUsuario(j).getCarrera();
            return c;
        } catch (Exception ex) {

        }
        return null;
    }

    public void loadEvents() throws BibliotecaException {
        eventModel = new DefaultScheduleModel();
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(recursoID);
        //Mouseky herramienta misteriosa 
        reservas.stream().map((reserva) -> {
            event = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFim());
            return reserva;
        }).forEachOrdered((_item) -> {
            eventModel.addEvent(event);
        });

    }

    public Reserva obtenerR() {
        try {
            resssss = serviciosBiblioteca.getInfoReserva(recursoID, event.getStartDate(), event.getEndDate());
            return serviciosBiblioteca.getInfoReserva(recursoID, event.getStartDate(), event.getEndDate());
        } catch (BibliotecaException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void modificarReserva(String a, String usuario) throws BibliotecaException {
        EstadoReserva estado = EstadoReserva.Cancelado;
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(recursoID);
        switch (a) {
            case "u":
                if (resssss.getUsuario().equals(usuario)) {
                    serviciosBiblioteca.modificarReserva(resssss, estado);
                    break;
                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solo el Usuario que hizo la reserva puede cancelarla", null);
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }

                break;
            case "t":
                if (resssss.getUsuario().equals(usuario)) {
                    for (Reserva r : reservas) {
                        if (r.getTitulo().equals(resssss.getTitulo())) {
                            serviciosBiblioteca.modificarReserva(r, estado);
                        }
                    }
                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solo el Usuario que hizo la reserva puede cancelarla", null);
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }
                break;
            default:

                if (resssss.getUsuario().equals(usuario)) {
                    serviciosBiblioteca.modificarReserva(resssss, estado);
                    for (Reserva r : reservas) {
                        if (r.getTitulo().equals(resssss.getTitulo()) && r.getDataInicio().after(resssss.getDataInicio())) {
                            serviciosBiblioteca.modificarReserva(r, estado);
                        }
                    }
                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solo el Usuario que hizo la reserva puede cancelarla", null);
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }
                break;
        }
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFretiempo() {
        return fretiempo;
    }

    public void setFretiempo(String fretiempo) {
        this.fretiempo = fretiempo;
    }
}
