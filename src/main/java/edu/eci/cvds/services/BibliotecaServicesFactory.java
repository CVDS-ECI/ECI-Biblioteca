package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.ReporteDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReporteDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.impl.BibliotecaServicesImpl;

public class BibliotecaServicesFactory {

	private static BibliotecaServicesFactory instance = new BibliotecaServicesFactory();

	private static Optional<Injector> optInjector = Optional.empty();

	private BibliotecaServicesFactory() {
	}

	private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				install(jdbcHelper);
				setClassPathResource(pathResource);
				bind(BibliotecaServices.class).to(BibliotecaServicesImpl.class);
				bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                                bind(ReporteDAO.class).to(MyBatisReporteDAO.class);
				
			}
		});
	}

	public BibliotecaServices getBlogServices() {
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml", JdbcHelper.MySQL));
		}

		return optInjector.get().getInstance(BibliotecaServices.class);
	}

	public static BibliotecaServicesFactory getInstance() {
		return instance;
	}

}
