package edu.eci.cvds.managedbeans.graphics;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.managedbeans.BasePageBean;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "recursosMasUsados")
@SessionScoped
public class RecursosMasUsadosPorPrograma extends BasePageBean {

    @Inject
    private BibliotecaServices serviciosBiblioteca;

    private String carrera="isis";
    private BarChartModel grafico;

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String car) {
        carrera = car;
    }

    public BarChartModel getGrafico() {
        createBarModel();
        return grafico;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries graph = new ChartSeries();
        graph.setLabel("Cantidad de reservas");
        List<Reserva> reservas;
        try {
            reservas = serviciosBiblioteca.consultarRecursosMasUsadosPorPrograma(carrera);
            for (Reserva r : reservas) {
                graph.set(r.getTitulo(), r.getCantidad());
            }


            model.addSeries(graph);

        } catch (BibliotecaException e) {
            e.printStackTrace();
        }

        return model;
    }

    private void createBarModel() {
        grafico = initBarModel();
        grafico.setTitle("Recursos más usados");
        grafico.setLegendPosition("ne");

        Axis xAxis = grafico.getAxis(AxisType.X);

        Axis yAxis = grafico.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(15);
        grafico.setSeriesColors("B00000");
    }
}
