/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.EstadoReserva;
import edu.eci.cvds.entities.Reserva;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Ing Pipe
 */
public interface ReservaMapper {

    public List<Reserva> listarReservasRecurso(@Param ("recursoId") int ru);

    public void salvar(@Param("reserva") Reserva rev);

    public void remover(@Param("reservaId") int rev);

    public Reserva getInfoReserva(@Param("rId") int recursoId,@Param("ini") Date inicio,@Param("fin") Date fin);

    public void modificarReserva(@Param("res") Reserva res,  @Param("estado") EstadoReserva estado);

    public List<Reserva> colsultarReservasCanceladasPorUsuario(@Param("correo") String correo);

    public List<Reserva> consultarReservasPasadasPorUsuario( @Param("correo") String correo);

    public List<Reserva> consultarReservasEnCursoPorUsuario(@Param("correo") String correo);

}
