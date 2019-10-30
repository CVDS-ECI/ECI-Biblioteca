/*
 * Copyright (C) 2016 salzate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

public abstract class BasePageBean implements Serializable {

	private static final long serialVersionUID = -2084921068710522276L;
	private Injector injector;

	public Injector getInjector() {
		if (injector == null) {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			injector = (Injector) servletContext.getAttribute(Injector.class.getName());
		}
		return injector;
	}

	public void setInjector(Injector injector) {
		this.injector = injector;
	}

	@PostConstruct
	public void init() {
		getInjector().injectMembers(this);
	}
}