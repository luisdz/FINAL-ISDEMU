/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.spring;

import javax.sql.DataSource;
import java.util.Properties;
//import javax.activation.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author Jose Eduardo
 */
@Configuration
@ComponentScan("com.isdemu")
@EnableWebMvc
@EnableTransactionManagement
@Import({ AppSecurityConfig.class })


public class WebAppConfig extends WebMvcConfigurerAdapter{
 
    public javax.sql.DataSource dataSource() {
		//DriverManagerDataSource dataSource = new DriverManagerDataSource();

//		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                 //jdbc:sqlserver://localhost;database=AdventureWorks;integratedSecurity=true;
//                //dataSource.setUrl("jdbc:sqlserver://192.168.10.187:1433;databaseName=ActivosFijosISDEMU");
//                //coneect edu18-11-15
//                dataSource.setUrl("jdbc:sqlserver://EDU:1433;databaseName=ActivosFijosISDEMU");
//		//dataSource.setUrl("jdbc:sqlserver://EDU\SQLEXPRESS:1433;databaseName=ActivosFijosISDEMU");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("admin123");
//
//		return dataSource;
        
        
         final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = (DataSource) dsLookup.getDataSource("jdbc/ActivosFijosISDEMU");
        return (javax.sql.DataSource) dataSource;
        
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
               
		sessionFactoryBean.setPackagesToScan("com.isdemu.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	final Properties hibernateProperties() {
        return new Properties() {
            private static final long serialVersionUID = 1L;
            {
                setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
                setProperty("hibernate.cache.use_second_level_cache", "false");
                setProperty("hibernate.cache.use_query_cache", "false");
                setProperty("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
                setProperty("hibernate.cglib.use_reflection_optimizer", "false");
                setProperty("hibernate.connection.release_mode", "after_transaction"); //IMPORTANTE PARA QUE LOS TEST NO FALLEN
                setProperty("hibernate.show_sql", "false");
                setProperty("hibernate.connection.autocommit", "false");                                
            }
        };
    }

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
           
            registry.addResourceHandler("/assets/**").addResourceLocations("/assets/"); 
    }  
}
