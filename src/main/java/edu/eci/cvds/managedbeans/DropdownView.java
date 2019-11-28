package edu.eci.cvds.managedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "dropdown")
@SessionScoped
public class DropdownView implements Serializable {

    private Map<String, Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String tipoDeFiltroSeleccionado;
    private String filtroSeleccionado;
    private Map<String,String> tipoDeFiltros;
    private Map<String,String> filtrosSeleccionados;

    @PostConstruct
    public void init() {
        tipoDeFiltros  = new TreeMap<String, String>();

//        tipoDeFiltros.put("Diaria", "Diaria");
//        tipoDeFiltros.put("Semanal", "Semanal");
//        tipoDeFiltros.put("Mensual", "Mensual");

        tipoDeFiltros.put("Fecha", "Fecha");
        tipoDeFiltros.put("Franja horaria", "Franja horaria");
        tipoDeFiltros.put("Carrera", "Carrera");
        tipoDeFiltros.put("Tipo de recurso", "Tipo de recurso");

        //Falta la fecha

        Map<String,String> map = new TreeMap<String, String>();
        map.put("7:00 am - 8:00 am", "7");
        map.put("8:01 am - 9:00 am", "8");
        map.put("9:01 am - 10:00 am", "9");
        map.put("10:01 am - 11:00 am", "10");
        map.put("11:01 am - 12:00 m", "11");
        map.put("12:01 m - 1:00 pm", "12");
        map.put("1:01 pm - 2:00 pm", "13");
        map.put("2:01 pm - 3:00 pm", "14");
        map.put("3:01 pm - 4:00 pm", "15");
        map.put("4:01 pm - 5:00 pm", "16");
        map.put("5:01 pm - 6:00 pm", "17");
        map.put("6:01 pm - 7:00 pm", "18");
        map.put("7:01 pm - 8:00 pm", "19");
        map.put("8:01 pm - 9:00 pm", "20");
        map.put("9:01 pm - 10:00 pm", "21");
        data.put("Franja horaria", map);

        map = new TreeMap<String, String>();
        map.put("Ingeniería de Sistemas", "sistemas");
        map.put("Ingeniería Electrónica", "electronica");
        map.put("Ingeniería Eléctrica", "electrica");
        map.put("Ingeniería Civil", "civil");
        map.put("Ingeniería Mecánica", "mecanica");
        map.put("Ingeniería Industrial", "industrial");
        map.put("Ingeniería Biomédica", "biomedica");
        map.put("Ingeniería Ambiental", "ambiental");
        map.put("Economía", "economia");
        map.put("Administración de Empresas", "administracion");
        map.put("Matemáticas", "matematicas");
        data.put("Carrera", map);

        map = new TreeMap<String, String>();
        map.put("Equipo de cómputo", "equipo");
        map.put("Sala de estudio", "sala");
        map.put("Libro", "libro");
        data.put("Tipo de recurso", map);
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getTipoDeFiltroSeleccionado() {
        return tipoDeFiltroSeleccionado;
    }

    public void setTipoDeFiltroSeleccionado(String tipoDeFiltroSeleccionado) {
        this.tipoDeFiltroSeleccionado = tipoDeFiltroSeleccionado;
    }

    public String getFiltroSeleccionado() {
        return filtroSeleccionado;
    }

    public void setFiltroSeleccionado(String filtroSeleccionado) {
        this.filtroSeleccionado = filtroSeleccionado;
    }

    public Map<String, String> getTipoDeFiltros() {
        return tipoDeFiltros;
    }

    public Map<String, String> getFiltrosSeleccionados() {
        return filtrosSeleccionados;
    }

    public void onTipoCambiado() {
        if(tipoDeFiltroSeleccionado !=null && !tipoDeFiltroSeleccionado.equals(""))
            filtrosSeleccionados = data.get(tipoDeFiltroSeleccionado);
        else
            filtrosSeleccionados = new HashMap<String, String>();
    }
}