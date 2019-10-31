package edu.eci.cvds.security;

import edu.eci.cvds.services.BibliotecaException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class ApacheShiroLogin implements Sesion {
    @Override
    public void login(String correo,String password) throws BibliotecaException {
        try{
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(correo, new Sha256Hash(password).toHex());
            currentUser.getSession().setAttribute("Correo",correo);
            currentUser.login( token );
        } catch ( UnknownAccountException uae ) {
            throw new BibliotecaException("El usuario no está registrado",uae);
        } catch ( IncorrectCredentialsException ice ) {
            throw new BibliotecaException("Contraseña incorrecta",ice);
        }
    }

    @Override
    public boolean estaLogeado() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}

