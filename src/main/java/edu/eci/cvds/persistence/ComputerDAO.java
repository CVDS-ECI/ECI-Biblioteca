/*
 * Copyright (C) 2018
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
package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Computer;
import edu.eci.cvds.entities.Element;

public interface ComputerDAO {

	public List<Computer> loadAll() throws PersistenceException;

	public void save(Computer c) throws PersistenceException;

	public void update(Computer c) throws PersistenceException;

	public void addElement(int computerId, Element element) throws PersistenceException;

	public Computer load(int computerID) throws PersistenceException;

	public Computer load(String reference) throws PersistenceException;
        
        public List<Computer> searchIncompleteComputers() throws PersistenceException;

	public List<Computer> loadByLaboratory(String name) throws PersistenceException;
        
        public List<Element> loadAssociatedElements(int id) throws PersistenceException;
}
