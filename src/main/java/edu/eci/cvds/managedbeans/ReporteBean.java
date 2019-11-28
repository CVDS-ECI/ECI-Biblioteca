package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.services.BibliotecaServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "reporteBean", eager = true)
@SessionScoped
public class ReporteBean extends BasePageBean {

    @Inject
    private BibliotecaServices serviciosBiblioteca;

}
