package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;


/**
 *
 * @author 2106913
 */
public interface UsuarioMapper {
    
	
    //public Usuario consultarCliente(@Param("idcli") long id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
	/*
    public void agregarItemRentadoACliente(@Param("idcli") long id, 
            @Param("idit")int idit, 
            @Param("fechai") Date fechainicio,
            @Param("fechaf") Date fechafin);
	*/
    /**
     * Consultar todos los clientes
     * @return 
     */
	/*
    public List<Usuario> consultarClientes();
    
    public void agregarCliente(@Param("cli") Usuario cliente);
    
    public List<ItemRentado> consultarItemsRentados(@Param("idcli") long documiento);
	*/
	public boolean iniciar_sesion(@Param("correo") String correo, @Param("clave") String clave);
		   
}

