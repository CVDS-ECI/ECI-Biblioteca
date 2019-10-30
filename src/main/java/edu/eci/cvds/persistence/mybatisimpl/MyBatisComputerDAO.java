/*
 * Copyright (C) 2016
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
package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Computer;
import edu.eci.cvds.entities.Element;
import edu.eci.cvds.persistence.ComputerDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.*;

public class MyBatisComputerDAO implements ComputerDAO {

	@Inject
	ComputerMapper computerMapper;
        
        @Inject
        ElementMapper elementMapper;

	@Override
	public List<Computer> loadAll() throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void save(Computer c) throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void update(Computer c) throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void addElement(int computerId, Element element) throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Computer load(int computerID) throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Computer load(String reference) throws PersistenceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Computer> loadByLaboratory(String name) throws PersistenceException {
		return computerMapper.findByLaboratory(name);
	}

    @Override
    public List<Element> loadAssociatedElements(int id) throws PersistenceException {
        return elementMapper.buscarElementosAsociados(id);
    }

    @Override
    public List<Computer> searchIncompleteComputers() throws PersistenceException {
        return computerMapper.searchIncompleteComputers();
    }
    
}
