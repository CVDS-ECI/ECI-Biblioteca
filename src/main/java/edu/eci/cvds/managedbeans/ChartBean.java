package edu.eci.cvds.managedbeans;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.services.BibliotecaException;
import edu.eci.cvds.services.BibliotecaServices;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "chartBean")
@SessionScoped
public class ChartBean extends BasePageBean {

    @Inject
    private BibliotecaServices serviciosBiblioteca;


    private BarChartModel barStatus;

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Reserva> status() throws BibliotecaException {
        return serviciosBiblioteca.consultarRecursosMasUsados();
    }



    public BarChartModel getBarStatus() {
        createBarModelStatus();
        return barStatus;
    }


    private BarChartModel initBarModelStatus() {
        BarChartModel model = new BarChartModel();
        ChartSeries status = new ChartSeries();
        status.setLabel("Cantidad de reservas");
        List<Reserva> c;
        try {
            c = serviciosBiblioteca.consultarRecursosMasUsados();
            for (Reserva ci : c) {
                status.set(ci.getTitulo(), ci.getCantidad());
            }


            model.addSeries(status);

        } catch (BibliotecaException e) {
            e.printStackTrace();
        }

        return model;
    }

    private void createBarModelStatus() {
        barStatus = initBarModelStatus();
        barStatus.setTitle("Recursos más usados");
        barStatus.setLegendPosition("ne");

        Axis xAxis = barStatus.getAxis(AxisType.X);

        Axis yAxis = barStatus.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(15);
        barStatus.setSeriesColors("B00000");
    }
}
