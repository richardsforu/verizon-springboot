package com.cts.product.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(value= {@ComponentScan("com.cts.product.service"),@ComponentScan("com.cts.product.dao")})
public class AppConfig {
	
	

}
