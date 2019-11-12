/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

@Named
@Stateless
@SessionScoped
@ManagedBean(name = "shiroBean", eager = true)
public class ShiroBean implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ShiroBean.class);

    private String username;
    private String password;
    private Boolean rememberMe = false;
    private String redirectUrl = "/faces/login.xhtml";
    Subject subject;

    /**
     * Try and authenticate the user
     */
    public void doLogin() {
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), new Sha256Hash(getPassword()).toHex());
        try {
            subject.login(token);
            if (subject.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin/paginas/recursos.xhtml");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("newxhtml.xhtml");
            }
        } catch (UnknownAccountException ex) {
            facesError("Unknown account");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            System.err.println("wrong password");
            facesError("Wrong password");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            facesError("Locked account");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException | IOException ex) {
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (NullPointerException e) {
            System.err.println("AAAAAAAAAAAA");
        } finally {
            token.clear();
        }
    }

    public void doLogOut() {

        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ShiroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     *
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
