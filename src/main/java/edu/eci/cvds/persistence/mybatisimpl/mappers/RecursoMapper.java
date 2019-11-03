package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

public interface RecursoMapper {
    public Recurso consultarRecurso(@Param("id") int id);
    
}
