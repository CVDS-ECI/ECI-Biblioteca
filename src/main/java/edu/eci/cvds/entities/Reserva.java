/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ing Pipe
 */
public class Reserva {

    private Long id;
    private String titulo;
    private Date dataInicio;
    private Date dataFim;
    private boolean diaInteiro;
    private TipoReserva tipoReserva;
    private String usuario;
    private int recurso;
    
// PILAS QUE FALTA USUARIO Y RECURSO PARA ESTO Y EL MAPPER

    public Reserva() {
        this.tipoReserva = TipoReserva.Ninguno;
        this.titulo = "";
        this.diaInteiro = false;

    }

    public Reserva(String usuario, int recurso, String titulo, Date dataInicio, Date dataFim, boolean diaInteiro, TipoReserva tipoReserva) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaInteiro = diaInteiro;
        this.tipoReserva = tipoReserva;
    }

    public Reserva(String usuario, int recurso, Long id, String titulo, Date dataInicio, Date dataFim, boolean diaInteiro, TipoReserva tipoReserva) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.id = id;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaInteiro = diaInteiro;
        this.tipoReserva = tipoReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isDiaInteiro() {
        return diaInteiro;
    }

    public void setDiaInteiro(boolean diaInteiro) {
        this.diaInteiro = diaInteiro;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RESERVA { id: " + id + ", titula: " + titulo + ", inicio: " + dataInicio
                + ", tipo: " + tipoReserva + ", fin: " + dataFim + ", diainteiro: " + diaInteiro + "}";
    }

}
