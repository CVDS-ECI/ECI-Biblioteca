package edu.eci.cvds.persistence.mybatisimpl.mappers;


import java.util.List;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;


/**
 *
 * @author 2106913
 */
public interface UsuarioMapper {
    
    public List<Usuario> consultarUsuarios();
    
    public Usuario consultarUsuario(@Param ("correoU") String correo);
    
}

