package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.List;

public class Laboratory {

	// El identificador es asignado por la base de datos,
	// por eso no se incluye en el constructor.
	private int id;
	private String name;
	private boolean active;
	private List<Computer> computers;

	public Laboratory() {
		this.computers = new ArrayList<>();
	}

	public Laboratory(String name, boolean active, List<Computer> computers) {
		this.name = name;
		this.active = active;
		this.computers = computers;
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

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	@Override
	public String toString() {
		StringBuilder rep = new StringBuilder(
				"Laboratory { id: " + id + ", name: " + name + ", active: " + active + ", computers : [\n");
		for (Computer computer : computers) {
			rep.append(computer + "\n");
		}
		rep.append("]}");
		return rep.toString();

	}

}
