package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class SpringBootJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(SpringBootJdbcTemplateApplication.class, args);
		Product prod=new Product();
		prod.setPrice(5455);
		prod.setProdId("P005");
		prod.setProdName("Blue Pen");
		
		ac.getBean(ProductService.class).persist(prod);
		
	
	}

}

