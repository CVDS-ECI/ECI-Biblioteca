package edu.eci.cvds.managedbeans;

import java.util.logging.Logger;

import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import edu.eci.cvds.services.LaboratoryServicesFactory;
//@ManagedBean
//@RequestScoped


public class ShiroBean {
	/*
	@SuppressWarnings("deprecation")
	@ManagedBean(name = "iniciar_sesion")
	@SessionScoped
	
	private static final Logger logger = LaboratoryServicesFactory.getLogger(InputSecretBackingBean.class);
	 
	@ManagedProperty(value = "#{inputSecretModelBean}")
	private InputSecretModelBean inputSecretModelBean;
 
	
	public void emailAddressValidator(FacesContext facesContext, UIComponent uiComponent, Object value)
		throws ValidatorException {
 
		if (value != null) {
 
			if (!value.toString().matches(".+[@].+[.].+")) {
				FacesMessage facesMessage = new FacesMessage();
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(facesMessage);
			}
		}
	}
 
	public void setInputSecretModelBean(InputSecretModelBean inputSecretModelBean) {
		this.inputSecretModelBean = inputSecretModelBean;
	}
 
	public void submit() {
		Object value = inputSecretModelBean.getPassword();
 
		if (value == null) {
			value = inputSecretModelBean.getDate();
		}
 
		logger.info("You entered: " + value);
	}
 
	public void submit1() {
		addGlobalInfoMessage("The alloy:inputSecret component was intentionally not re-rendered in the DOM.");
		submit();
	}
 
	public void submit2() {
		addGlobalInfoMessage("The entire form (including the alloy:inputSecret component) was re-rendered in the DOM.");
		submit();
	}
 
	public void valueChangeListener(ValueChangeEvent valueChangeEvent) {
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		PhaseId phaseId = facesContext.getCurrentPhaseId();
		logger.debug("valueChangeListener: phaseId=[{0}]", phaseId.toString());
 
		String phaseName = phaseId.toString();
		FacesMessage facesMessage = new FacesMessage("The valueChangeListener method was called during the " +
				phaseName + " phase of the JSF lifecycle.");
		facesContext.addMessage(null, facesMessage);
	}
 
	protected void addGlobalInfoMessage(String summary) {
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		facesMessage.setSummary(summary);
		facesContext.addMessage(null, facesMessage);
	}
	*/
}
