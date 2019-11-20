/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoReserva;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static org.primefaces.behavior.validate.ClientValidator.PropertyKeys.event;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Ing Pipe
 */
@ManagedBean(name = "reservaBean", eager = true)
@SessionScoped
public class ReservaBean extends BasePageBean implements Serializable {

    @Inject
    private BibliotecaServices serviciosBiblioteca;

    private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent event = new DefaultScheduleEvent();
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
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
    }

    public void addEvent() throws BibliotecaException {
        if (event.getId() == null) {
            //addEvent(String Usuario, int idRecurso,TipoReserva res, int Duracion)
            /* En esta linea se deben llamar al metodo recursion,con los parametros especificados
            es decir addEvent tambien deberia tener tipoReserva y Duracion todo depende de los campos 
            que los de vista deben hacer :V
             */

            recursion("marcelo", 3111, TipoReserva.Diario, 3);

        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void recursion(String usuario, int idRecurso, TipoReserva res, int duracion) throws BibliotecaException {
        //Primera Reserva Sin Importar la Recursion
        // for 

        if (validarInsercion(event)) {
            eventModel.addEvent(event);
            serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, event.getTitle(), event.getStartDate(), event.getEndDate(), false, res));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PAILAASSSS KRAKKK", null));
            return;
            
        }
        if (res != TipoReserva.Ninguno) {
            Date startDate;
            Date endDate;
            // Reserva Recursiva que es la Anterios + todas las reservas que faltan acorde a la duracion
            for (int i = 1; i < duracion; i++) {
                startDate = sumaFecha(event.getStartDate(), res);
                endDate = sumaFecha(event.getEndDate(), res);

                event = new DefaultScheduleEvent(event.getTitle() + " -> " + i, startDate, endDate);
                if (validarInsercion(event)) {
                    serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, event.getTitle(), startDate, endDate, false, res));
                    System.out.println(event.getStartDate());
                    eventModel.addEvent(event);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PAILAASSSS KRAKKK", null));
                    return;
                }
            }
        }
    }

    private boolean validarInsercion(ScheduleEvent evento) throws BibliotecaException {
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(3111);
        return reservas.stream().map((res) -> {
            System.err.println("vOY A ENTRAR SUUUUUU");
            return res;
        }).noneMatch((res) -> (evento.getStartDate().compareTo(res.getDataInicio())==0 && evento.getEndDate().compareTo(res.getDataFim())==0));
    }

    private Date sumaFecha(Date fecha, TipoReserva res) {
        dateFormat.format(fecha);
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        switch (res) {
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

    public void loadEvents() throws BibliotecaException {
        eventModel = new DefaultScheduleModel();
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(3111);
        //Mouseky herramienta misteriosa 
        reservas.stream().map((reserva) -> {
            event = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFim());
            return reserva;
        }).forEachOrdered((_item) -> {
            eventModel.addEvent(event);
        });

    }
}
