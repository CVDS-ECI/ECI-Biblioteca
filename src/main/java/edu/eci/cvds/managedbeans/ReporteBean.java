package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
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


    public List<Reserva> consultarReservasPorCarrera() {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasPorCarrera();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }

    public List<Reserva> consultarReservasPorUsuario() {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasPorUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }



    public List<Reserva> consultarRecursosMasUsados() {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMasUsados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }

    public List<Reserva> consultarRecursosMenosUsados() {
        List<Reserva> recursos = new ArrayList<>();
        try {
            recursos = serviciosBiblioteca.consultarRecursosMenosUsados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }
        
    public List<Reserva> consultarRecursosMasUsadosPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMasUsadosPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarRecursosMasUsadosPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMasUsadosPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }

    public static void main(String[] args) {
        ReporteBean reporteBean = new ReporteBean();
        List<Reserva> x = reporteBean.consultarRecursosMasUsadosPorPrograma("ISIS");
        System.out.println(x);
    }
   
    private List<Reserva> consultarRecursosMasUsadosPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMasUsadosPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarRecursosMasUsadosPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMasUsadosPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return recurso;

    }
   
    public List<Reserva> consultarRecursosMenosUsadosPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMenosUsadosPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
    
    public List<Reserva> consultarRecursosMenosUsadosPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMenosUsadosPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarRecursosMenosUsadosPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMenosUsadosPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
    
    public List<Reserva> consultarRecursosMenosUsadosPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarRecursosMenosUsadosPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return recurso;

    }
  
    public List<Reserva> consultarHorariosMayorOcupacionPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMayorOcupacionPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return recurso;

    }
    
    public List<Reserva> consultarHorariosMayorOcupacionPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMayorOcupacionPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMayorOcupacionPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMayorOcupacionPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMayorOcupacionPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMayorOcupacionPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMayorOcupacion()  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMayorOcupacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMenorOcupacionPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMenorOcupacionPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
    
    public List<Reserva> consultarHorariosMenorOcupacionPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMenorOcupacionPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMenorOcupacionPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMenorOcupacionPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
    
    public List<Reserva> consultarHorariosMenorOcupacionPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMenorOcupacionPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarHorariosMenorOcupacion()  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarHorariosMenorOcupacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasRecurrentesPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasRecurrentesPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasRecurrentesPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasRecurrentesPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasRecurrentesPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasRecurrentesPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasRecurrentesPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasRecurrentesPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasRecurrentes()  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasRecurrentes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
    
    public List<Reserva> consultarReservasCanceladasPorFecha(String date1, String date2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasCanceladasPorFecha(date1, date2);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return recurso;

    }
    
    public List<Reserva> consultarReservasCanceladasPorHora(String hora1, String hora2)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasCanceladasPorHora(hora1, hora2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
   
    public List<Reserva> consultarReservasCanceladasPorPrograma(String programa)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasCanceladasPorPrograma(programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }
 
    public List<Reserva> consultarReservasCanceladasPorTipoRecurso(String tipoRecurso)  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasCanceladasPorTipoRecurso(tipoRecurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

    }

    public List<Reserva> consultarReservasCanceladas()  {
        List<Reserva> recurso = new ArrayList<>();
        try {
            recurso = serviciosBiblioteca.consultarReservasCanceladas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;

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
