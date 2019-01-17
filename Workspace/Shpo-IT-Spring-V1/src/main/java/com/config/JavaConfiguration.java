package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScans(value= {@ComponentScan("com.pricematrix"),@ComponentScan("com.billing")})
@PropertySource(value= {"application.properties"})
public class JavaConfiguration {

	@Autowired
	private Environment env;
	
	public JavaConfiguration() {
		System.out.println("-- JavaConfiguration");
	}
	
	@Bean
	void connectionData() {
		
		System.out.println("-- Name is "+env.getProperty("name"));
		
	}
	
	@Bean
	DataSource getConnection() {
		
		System.out.println("--- f1 method of JavaConfigurationClass");
		
		return null;
	}
	

}
