package com.mycompany.ebookRest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan({"com.mycompany.ebookRest"})
public class HibernateConfig {

	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() throws PropertyVetoException {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());		
		sessionFactoryBean.setPackagesToScan(new String[] { "com.mycompany.ebookRest.entity" });
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
	
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/library");
		ds.setUser("root");
		ds.setPassword("pass1234");
		
		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(10);
		ds.setMaxIdleTime(30000);
		
		return ds;
	}
	
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		  properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		  properties.put("hibernate.show_sql", "true");
		  properties.put("hibernate.format_sql", "false");
		  
		  return properties;
	}
	
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
		
	}
	
}
