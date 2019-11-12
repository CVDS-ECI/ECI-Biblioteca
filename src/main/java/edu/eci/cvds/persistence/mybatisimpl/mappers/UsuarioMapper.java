package edu.eci.cvds.persistence.mybatisimpl.mappers;


import java.util.List;
import edu.eci.cvds.entities.Usuario;


/**
 *
 * @author 2106913
 */
public interface UsuarioMapper {
    
    public List<Usuario> consultarUsuarios();
    
}

