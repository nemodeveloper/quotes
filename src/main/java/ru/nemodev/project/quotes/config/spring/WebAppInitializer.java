package ru.nemodev.project.quotes.config.spring;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * created by sbrf-simanov-an on 20.11.2018 - 15:26
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    private static final String SPRING_PROFILES_ACTIVE_KEY = "spring.profiles.active";

    private static String getActiveProfiles()
    {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setSingleton(false);
        propertiesFactoryBean.setLocations(new ClassPathResource("config/application.properties"));

        try
        {
            return propertiesFactoryBean.getObject().getProperty(SPRING_PROFILES_ACTIVE_KEY);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        servletContext.setInitParameter(SPRING_PROFILES_ACTIVE_KEY, getActiveProfiles());
        super.onStartup(servletContext);
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] {"/rest/*" };
    }

    @Override
    protected String getServletName()
    {
        return "SpringRestServlet";
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[] {ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[] {WebConfig.class};
    }
}
