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
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReservaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.joda.time.DateTime;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Ing Pipe
 */
@Named
@ViewScoped
public class ScheduleBean implements Serializable {

    private ScheduleModel model;
    private Reserva evento;
    private ScheduleEvent event;
    private List<ScheduleEvent> scheduleEvents;
    @Inject
    private ReservaDAO eventoDAO;
    private static final Logger LOG = Logger.getLogger(ScheduleBean.class.getName());

    public ScheduleBean() {
        event = new CustomScheduleEvent();
        model = new DefaultScheduleModel();
        evento = new Reserva();
    }

    @PostConstruct
    public void init() throws PersistenceException {
        if (this.model != null) {
            List<Reserva> eventos = this.eventoDAO.listarTodos();
            if (this.scheduleEvents == null) {
                this.scheduleEvents = new ArrayList();
            }
            for (Reserva eventoAtual : eventos) {
                ScheduleEvent newEvent = new CustomScheduleEvent(eventoAtual.getTitulo(), eventoAtual.getDataInicio(), eventoAtual.getDataFim(), eventoAtual.getTipoReserva().getCss(), eventoAtual.isDiaInteiro(), eventoAtual);
                if (!this.scheduleEvents.contains(newEvent)) {
                    newEvent.setId(eventoAtual.getId().toString());
                    this.scheduleEvents.add(newEvent);
                    this.model.addEvent(newEvent);
                }
            }
        }
    }

    public Reserva getReserva() {
        return evento;
    }

    public void setReserva(Reserva evento) {
        this.evento = evento;
    }

    public void salvar() throws PersistenceException {
        ScheduleEvent newEvent = new CustomScheduleEvent(this.evento.getTitulo(), this.evento.getDataInicio(), this.evento.getDataFim(), this.evento.getTipoReserva().getCss(), this.evento.isDiaInteiro(), this.evento);
        if (evento.getId() == null) {
            model.addEvent(newEvent);
        } else {
            newEvent.setId(event.getId());
            model.updateEvent(newEvent);
        }
        eventoDAO.salvar(evento);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva Salvo", "Reserva Salvo");
        addMessage(message);
    }

    public void remover() throws PersistenceException {
        model.deleteEvent(event);
        eventoDAO.remover(evento);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva Removido", "Reserva Removido");
        addMessage(message);
    }

    public void onDateSelect(SelectEvent selectEvent) {
        this.evento = new Reserva();
        Date dataSelecionada = (Date) selectEvent.getObject();
        DateTime dataSelecionadaJoda = new DateTime(dataSelecionada.getTime());
        this.evento.setDataInicio(dataSelecionada);
        this.evento.setDataFim(dataSelecionadaJoda.plusHours(1).toDate());
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (CustomScheduleEvent) selectEvent.getObject();
        this.evento = (Reserva) event.getData();
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva Redimensionado", "Dia:" + event.getDayDelta() + ", Horário:" + event.getMinuteDelta());
        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public TipoReserva[] getTiposReservas() {
        return TipoReserva.values();
    }
}
