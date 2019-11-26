/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

/**
 *
 * @author Ing Pipe
 */
public enum TipoReserva {
    /* TIPO DE EVENTO - CSS */
    PADRAO("Padrão", ""),
    URGENTE("Urgente", "urgente"),
    CANCELADO("Cancelado", "cancelado");

    private final String descripcion;
    private final String css;

    private TipoReserva(String descricao, String css) {
        this.css = css;
        this.descripcion = descricao;
    }

    public String getCss() {
        return css;
    }

    public String getDescricao() {
        return descripcion;
    }
}
