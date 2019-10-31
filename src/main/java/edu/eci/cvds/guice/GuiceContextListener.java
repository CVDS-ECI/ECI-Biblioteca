package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.ComputerDAO;
import edu.eci.cvds.persistence.LaboratoryDAO;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisComputerDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisLaboratoryDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.LaboratoryServices;
import edu.eci.cvds.services.impl.LaboratoryServicesImpl;


public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.MySQL);
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");

				// Laboratories
                bind(LaboratoryServices.class).to(LaboratoryServicesImpl.class);
                bind(ComputerDAO.class).to(MyBatisComputerDAO.class);
				// Computers
                bind(LaboratoryDAO.class).to(MyBatisLaboratoryDAO.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}