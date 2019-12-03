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
    private Date dataActual;
    private Date dataInicio;
    private Date dataFim;
    private boolean diaInteiro;
    private TipoReserva tipoReserva;
    private String usuario;
    private int recurso;
    private int cantidad;
    
// PILAS QUE FALTA USUARIO Y RECURSO PARA ESTO Y EL MAPPER
    private EstadoReserva estado;
    private Date proximaOcurrencia;



// PILAS QUE FALTA USUARIO Y RECURSO PARA ESTO Y EL MAPPER
    public Reserva() {
        this.tipoReserva = TipoReserva.Ninguno;
        this.titulo = "";
        this.diaInteiro = false;

    }

    public Reserva(String usuario, int recurso, String titulo, Date dataActual, Date dataInicio, Date dataFim, boolean diaInteiro, TipoReserva tipoReserva, EstadoReserva estado, Date proximaOcurrencia) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.titulo = titulo;
        this.dataActual = dataActual;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaInteiro = diaInteiro;
        this.tipoReserva = tipoReserva;
        this.estado = estado;
        this.proximaOcurrencia = proximaOcurrencia;
    }

    public Reserva(String usuario, int recurso, Long id, String titulo, Date dataActual, Date dataInicio, Date dataFim, boolean diaInteiro, TipoReserva tipoReserva, EstadoReserva estado, Date proximaOcurrencia) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.id = id;
        this.titulo = titulo;
        this.dataActual = dataActual;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaInteiro = diaInteiro;
        this.tipoReserva = tipoReserva;
        this.estado = estado;
        this.proximaOcurrencia = proximaOcurrencia;
    
    }


    
    
    public Date getProximaOcurrencia() {
        return proximaOcurrencia;
    }

    public void setProximaOcurrencia(Date proximaOcurrencia) {
        this.proximaOcurrencia = proximaOcurrencia;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
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

    public Date getDataActual() {
        return dataActual;
    }

    public void setDataActual(Date dataActual) {
        this.dataActual = dataActual;
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

    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "RESERVA { id: " + id + "Usuario:" + usuario + "Recurso" + recurso + ", titula: " + titulo + ", inicio: " + dataInicio
                + ", tipo: " + tipoReserva + ", fin: " + dataFim + ", diainteiro: " + diaInteiro + "}";
    }

}
