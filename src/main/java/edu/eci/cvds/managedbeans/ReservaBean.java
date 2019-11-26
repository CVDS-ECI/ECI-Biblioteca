/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.CustomScheduleEvent;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class ReservaBean extends BasePageBean implements Serializable {

    
    @ManagedProperty(value = "#{param.recursoID}")
    private int recursoID;
    
    
    
    private static final long serialVersionUID = 3594009161252782831L;
    @Inject
    private BibliotecaServices serviciosBiblioteca;

    private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent event = new DefaultScheduleEvent();
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private TipoReserva frecuencia;
    

    public int getRecursoID() {
        System.err.println(recursoID);
        return recursoID;
    }

    public void setRecursoID(int recursoID) {
        System.err.println(recursoID);
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
//        System.err.println(datee + "gggggggg");
        return datee;
    }

    public void setDatee(int datee) {
//        System.err.println(datee + "sssssss");
        this.datee = datee;
    }

    public void crearEvento(Date start, Date end, String usuario, int idRecurso, String recurrencia, String duracion) throws BibliotecaException {

//        System.err.println(start);
//        System.err.println(end);
//        System.err.println(usuario);
//        System.err.println(idRecurso);
//        System.err.println(this.frecuencia);
//        System.err.println(this.frecuencia.getClass());
//        System.err.println(recurrencia);
//        System.err.println(duracion);
        duracion = duracion.replaceAll("\\D+", "");
        int numero = Integer.parseInt(duracion);

        if (numero == 1) {
            end = sumaFecha(end, TipoReserva.Ninguno);
        } else if (numero == 2) {
            end = sumaFecha(end, TipoReserva.Ninguno);
            end = sumaFecha(end, TipoReserva.Ninguno);
        }
//        System.err.println(start);
//        System.err.println(end);
//
//        System.err.println(numero);

        if (validarInsercionFechas(start, end, idRecurso)) {
            serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, frecuencia.toString(), start, end, false, this.frecuencia));
        } else {
//            System.err.println("AYAYAYAYAYAYAYAYYAYAYAYYAYA%");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PAILAASSSS KRAKKK", null));
        }

        for (int i = 1; i < numero; i++) {
            start = sumaFecha(start, this.frecuencia);
            end = sumaFecha(end, this.frecuencia);
            if (validarInsercionFechas(start, end, idRecurso)) {
//                System.err.println("Entrando en IFFFFFFFFFFFFFFFF");
//                System.err.println(usuario);
//                System.err.println(idRecurso);
//                System.err.println(start);
//                System.err.println(end);
//                System.err.println(this.frecuencia);

                serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, frecuencia.toString(), start, end, false, this.frecuencia));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PAILAASSSS KRAKKK", null));
                return;
            }
        }

//        try {
//            serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, event.getTitle(), event.getStartDate(), event.getEndDate(), false, res));
//        } catch (BibliotecaException ex) {
//            Logger.getLogger(ReservaBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private boolean validarInsercionFechas(Date start, Date end, int idrecurso) throws BibliotecaException {
        //Falta pensar si la horafin es menor
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(idrecurso);
        return reservas.stream().map((res) -> {
//            System.err.println("vOY A ENTRAR SUUUUUU@@@@@@@");
            return res;
        }).noneMatch((res) -> (start.compareTo(res.getDataInicio()) == 0 && end.compareTo(res.getDataFim()) == 0));
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

//            recursion("marcelo", 3111, TipoReserva.Diario, 3);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void recursion(String usuario, int idRecurso, TipoReserva res, int duracion) throws BibliotecaException {
        //Primera Reserva Sin Importar la Recursion
        // for 
        if (event.isAllDay()) {
            if (validarInsercion(event, idRecurso)) {
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
                    if (validarInsercion(event, idRecurso)) {
                        serviciosBiblioteca.registrarReserva(new Reserva(usuario, idRecurso, event.getTitle(), startDate, endDate, false, res));
//                        System.out.println(event.getStartDate());
                        eventModel.addEvent(event);
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PAILAASSSS KRAKKK", null));
                        return;
                    }
                }
            }
        }
    }

    private boolean validarInsercion(ScheduleEvent evento, int idrecurso) throws BibliotecaException {
        //Falta pensar si la horafin es menor
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(idrecurso);
        return reservas.stream().map((res) -> {
//            System.err.println("vOY A ENTRAR SUUUUUU");
            return res;
        }).noneMatch((res) -> (evento.getStartDate().compareTo(res.getDataInicio()) == 0 && evento.getEndDate().compareTo(res.getDataFim()) == 0));
    }

    public void loadEvents() throws BibliotecaException {
        eventModel = new DefaultScheduleModel();
        System.err.println(recursoID+"load");
        List<Reserva> reservas = serviciosBiblioteca.listarReservasRecurso(recursoID);
        System.err.println(reservas.size());
        //Mouseky herramienta misteriosa 
        reservas.stream().map((reserva) -> {
            event = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFim());
            return reserva;
        }).forEachOrdered((_item) -> {
            eventModel.addEvent(event);
        });
        System.err.println(eventModel.getEventCount()+"largoooooo");

    }
}
