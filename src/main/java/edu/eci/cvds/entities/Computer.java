package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.List;

public class Computer {

	// El identificador es asignado por la base de datos,
	// por eso no se incluye en el constructor.
	private int id;
	private String name;
	private boolean active;
	private List<Element> elements;

	public Computer() {
		this.elements = new ArrayList<>();
	}

	public Computer(String name, boolean active, List<Element> elements) {

		this.name = name;
		this.active = active;
		this.elements = elements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		StringBuilder rep = new StringBuilder(
				"Computer: { id:" + id + ", name: " + name + ", active: " + active + ", elements : [\n");
		for (Element comment : elements) {
			rep.append(comment + "\n");
		}
		rep.append("]}");
		return rep.toString();
	}

}
