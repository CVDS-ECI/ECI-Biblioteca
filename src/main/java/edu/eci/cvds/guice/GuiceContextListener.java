package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.ReporteDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReporteDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.impl.BibliotecaServicesImpl;

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
                bind(BibliotecaServices.class).to(BibliotecaServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                bind(ReporteDAO.class).to(MyBatisReporteDAO.class);
                
            }
        }
        );

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}
