/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ing Pipe
 */
public class MyBatisReservaDAO implements ReservaDAO {

    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public List<Reserva> listarReservasRecurso(int ru) throws PersistenceException {
        try {
            return reservaMapper.listarReservasRecurso(ru);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al consultar reserva:", e);

        }
    }

    @Override
    public void salvar(Reserva rv) throws PersistenceException {
        try {
            reservaMapper.salvar(rv);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al consultar reserva:", e);

        }
    }

    @Override
    public void remover(int rv) throws PersistenceException {
        try {
            reservaMapper.remover(rv);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al consultar reserva:", e);

        }
    }

    @Override
    public Reserva getInfoReserva(int recursoId, Date inicio, Date fin) throws PersistenceException {
        try {
            return reservaMapper.getInfoReserva(recursoId, inicio, fin);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al consultar reserva:", e);

        }
    }

    @Override
    public void modificarReserva(Reserva res, EstadoReserva estado) throws PersistenceException {
        try {
            reservaMapper.modificarReserva(res,estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {

            throw new PersistenceException("Error al modificar reserva:", e);

        }
    }

}
