package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.BibliotecaServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "reporteBean", eager = true)
@SessionScoped
public class ReporteBean extends BasePageBean {

    @Inject
    private BibliotecaServices serviciosBiblioteca;
    private String[] TiposDeReportes = {"Recursos más usados", "Recursos menos usados", "Horarios de mayor ocupación de recursos", "Horarios de menor ocupación de recursos", "Reservas recurrentes", "Reservas canceladas"};
    private String[] TiposDeFiltros = {"Fecha", "Franja horaria", "Carrera", "Tipo de recurso"};
    private String tipoDeReporteSeleccionado;
    private String tipoDeFiltroSeleccionado;

    public List<Recurso> consultarRecursosMasUsados() {
        List<Recurso> recursos = new ArrayList<>();
        try {
            //recursos = serviciosBiblioteca.consultarRecursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }

    public List<Recurso> consultarRecursosMenosUsados() {
        List<Recurso> recursos = new ArrayList<>();
        try {
            //recursos = serviciosBiblioteca.consultarRecursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }

    public String[] getTiposDeReportes() {
        return TiposDeReportes;
    }

    public void setTiposDeReportes(String[] tiposDeReportes) {
        TiposDeReportes = tiposDeReportes;
    }

    public String[] getTiposDeFiltros() {
        return TiposDeFiltros;
    }

    public void setTiposDeFiltros(String[] tiposDeFiltros) {
        TiposDeFiltros = tiposDeFiltros;
    }

    public String getTipoDeReporteSeleccionado() {
        return tipoDeReporteSeleccionado;
    }

    public void setTipoDeReporteSeleccionado(String tipoDeReporteSeleccionado) {
        this.tipoDeReporteSeleccionado = tipoDeReporteSeleccionado;
    }

    public String getTipoDeFiltroSeleccionado() {
        return tipoDeFiltroSeleccionado;
    }

    public void setTipoDeFiltroSeleccionado(String tipoDeFiltroSeleccionado) {
        this.tipoDeFiltroSeleccionado = tipoDeFiltroSeleccionado;
    }
}
