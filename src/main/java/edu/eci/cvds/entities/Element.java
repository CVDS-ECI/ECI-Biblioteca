package edu.eci.cvds.entities;

public class Element {

	// El identificador es asignado por la base de datos,
	// por eso no se incluye en el constructor.
	private int id;
	private String serialNo;
	private ElementType type;
	private String brand;
	private boolean active;

	public Element() {}
	
	public Element(String serialNo, ElementType type, String brand, boolean active) {

		this.serialNo = serialNo;
		this.type = type;
		this.brand = brand;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public ElementType getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public boolean isActive() {
		return active;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Element { id: " + id + ", serialNo: " + serialNo + ", brand: " + brand + ", type: " + type
				+ ", active: " + active + " }";
	}

}
