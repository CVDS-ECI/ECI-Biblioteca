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
@ManagedBean(name = "computerBean")
@RequestScoped
public class ComputerBean extends BasePageBean {

    @ManagedProperty(value = "#{param.laboratory}")
    private String laboratory;


    /**
     *
     */
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private LaboratoryServices laboratoryServices;

    public List<Computer> getComputers() throws Exception {
        try {
            if (laboratory == null) {
                return laboratoryServices.listComputers();
            } else {
                return laboratoryServices.searchByLaboratory(laboratory);
            }
        } catch (ServicesException ex) {

            throw ex;
        }

    }
    
        public List<Computer> getIncompleteComputers() throws Exception {
        try {
            return laboratoryServices.searchIncompleteComputers();

        } catch (ServicesException ex) {

            throw ex;
        }

    }
    
    

    /**
     * @return the laboratory
     */
    public String getLaboratory() {
        return laboratory;
    }

    /**
     * @param laboratory the laboratory to set
     */
    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }


}
