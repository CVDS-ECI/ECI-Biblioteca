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

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.cvds.entities.Laboratory;
import edu.eci.cvds.services.LaboratoryServices;
import edu.eci.cvds.services.ServicesException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratoryBean")
@SessionScoped
public class LaboratoryBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private LaboratoryServices laboratoryServices;

    public List<Laboratory> getLaboratories() throws Exception{
        try {
            return laboratoryServices.listLaboratories();
        } catch (ServicesException ex) {
            
            throw ex;
        }
        
    }

    
}
