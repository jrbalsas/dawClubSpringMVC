/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.club;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring +3.0 programmatic configuration
 *
 * @author jrbalsas
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.daw.club"})
public class SpringMvcConfig implements WebMvcConfigurer {

    private DataSource ds;

    /**
     * This is intended to be used when the Spring MVC DispatcherServlet is
     * mapped to "/" thus overriding the Servlet container's default handling of
     * static resources.
     */
//  @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
    @Bean
    public DataSource getDataSource() {
        
        if (ds == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:global/jdbc/gestClub");
            } catch (NamingException e) {
                Logger.getGlobal().log(Level.SEVERE, e.getMessage());
            }
        }
        return ds;        
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource ds) {
        JdbcTemplate jt=null;
        if (ds!=null) {
            jt=new JdbcTemplate(ds);
        }
        return jt;
    }
    
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
