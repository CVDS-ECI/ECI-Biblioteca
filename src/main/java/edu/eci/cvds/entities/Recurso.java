package edu.eci.cvds.entities;

import java.sql.Date;

public class Recurso {

	// El identificador es asignado por la base de datos,
	// por eso no se incluye en el constructor.
	private String nombre;
	private String ubicacion;
	private String tipo;
	private int capacidad;
	private boolean estado_reserva;
	private String identificador_Interno;
	private Date horario_disponible;
	
	
	public Recurso() {}
	
	public Recurso(String nombre, String ubicacion, String tipo, int capacidad,String identificador_Interno) {

		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.estado_reserva = true;
		this.identificador_Interno=identificador_Interno;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEstado_reserva() {
		return estado_reserva;
	}

	public void setEstado_reserva(boolean estado_reserva) {
		this.estado_reserva = estado_reserva;
	}

	public String getIdentificador_Interno() {
		return identificador_Interno;
	}

	public void setIdentificador_Interno(String identificador_Interno) {
		this.identificador_Interno = identificador_Interno;
	}

	public Date getHorario_disponible() {
		return horario_disponible;
	}

	public void setHorario_disponible(Date horario_disponible) {
		this.horario_disponible = horario_disponible;
	}
	
/*
	@Override
	public String toString() {
		return "Element { id: " + id + ", serialNo: " + serialNo + ", brand: " + brand + ", type: " + type
				+ ", active: " + active + " }";
	}
*/
}
