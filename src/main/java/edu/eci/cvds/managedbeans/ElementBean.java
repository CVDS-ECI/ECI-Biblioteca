package edu.eci.cvds.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.eci.cvds.entities.Computer;
import edu.eci.cvds.entities.Element;
import edu.eci.cvds.services.LaboratoryServices;
import edu.eci.cvds.services.ServicesException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("deprecation")
@ManagedBean(name = "elementBean")
@RequestScoped
public class ElementBean extends BasePageBean {

    @ManagedProperty(value = "#{param.computer}")
    private String computer;


    /**
     *
     */
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private LaboratoryServices laboratoryServices;

    public List<Element> getElements() throws Exception {
        try {
            if (computer == null) {
                return null;
            } else {
                return laboratoryServices.buscarElementosAsociadosAUnComputador(Integer.parseInt(computer));
            }
        } catch (ServicesException ex) {

            throw ex;
        }

    }

    /**
     * @return the computer
     */
    public String getComputer() {
        return computer;
    }

    /**
     * @param computer the computer to set
     */
    public void setComputer(String computer) {
        this.computer = computer;
    }

}