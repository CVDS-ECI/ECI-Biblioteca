/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Ing Pipe
 */
public interface ReservaMapper {

    public List<Reserva> consultarReservas();

    public void salvar(@Param("reserva") Reserva rev);

    public void remover(@Param("reserva") Reserva rev);

}
