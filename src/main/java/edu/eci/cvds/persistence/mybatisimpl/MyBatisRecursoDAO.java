package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBatisRecursoDAO implements RecursoDAO{
	@Inject
    private RecursoMapper recursoMapper;
}
