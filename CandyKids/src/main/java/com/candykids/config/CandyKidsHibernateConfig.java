package com.candykids.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.candykids.entity")
@PropertySource(value= {"classpath:db.properties"})
public class CandyKidsHibernateConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource() throws Exception {
		ComboPooledDataSource ds=new ComboPooledDataSource();
		ds.setDriverClass(env.getProperty("mysql.driverclass"));
		ds.setJdbcUrl(env.getProperty("mysql.jdbcurl"));
		ds.setUser(env.getProperty("mysql.user"));
		ds.setPassword(env.getProperty("mysql.password"));
		ds.setMinPoolSize(getIntPropertyValue("mysql.minpoolsize"));
		ds.setMaxPoolSize(getIntPropertyValue("mysql.maxpoolsize"));
		ds.setMaxIdleTime(getIntPropertyValue("mysql.maxidletime"));
		
		return ds;
	}
	
	private int getIntPropertyValue(String propertyName) {
		String propertval=env.getProperty(propertyName);
		int propertyValueInt=Integer.parseInt(propertval);
		return propertyValueInt;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws Exception {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(myDataSource());
		sf.setPackagesToScan("com.candykids.entity");
		Properties props=new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		sf.setHibernateProperties(props);
		
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager myTransactionManager() throws Exception {
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionFactory().getObject());
		
		return tm;
	}
}
