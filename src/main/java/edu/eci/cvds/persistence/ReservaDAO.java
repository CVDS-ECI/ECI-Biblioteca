/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Reserva;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ing Pipe
 */
public interface ReservaDAO {
    public List<Reserva> listarReservasRecurso(int ru) throws PersistenceException;
    
    public void salvar(Reserva rv) throws PersistenceException;
    
    public void remover(int rv) throws PersistenceException;

    public Reserva getInfoReserva(int recursoId, Date inicio, Date fin) throws PersistenceException;

    public void modificarReserva(Reserva res, EstadoReserva estado) throws PersistenceException;
    
}
