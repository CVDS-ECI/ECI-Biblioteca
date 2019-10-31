package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.cvds.persistence.ComputerDAO;
import edu.eci.cvds.persistence.LaboratoryDAO;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisComputerDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisLaboratoryDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.impl.LaboratoryServicesImpl;

public class LaboratoryServicesFactory {

	private static LaboratoryServicesFactory instance = new LaboratoryServicesFactory();

	private static Optional<Injector> optInjector = Optional.empty();

	private LaboratoryServicesFactory() {
	}

	private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				install(jdbcHelper);
				setClassPathResource(pathResource);

				bind(LaboratoryServices.class).to(LaboratoryServicesImpl.class);
				bind(LaboratoryDAO.class).to(MyBatisLaboratoryDAO.class);
				bind(ComputerDAO.class).to(MyBatisComputerDAO.class);
				bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				
			}
		});
	}

	public LaboratoryServices getBlogServices() {
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml", JdbcHelper.MySQL));
		}

		return optInjector.get().getInstance(LaboratoryServices.class);
	}

	public static LaboratoryServicesFactory getInstance() {
		return instance;
	}

}
