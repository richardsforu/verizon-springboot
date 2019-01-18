package com.cts;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(SpringBootJpaApplication.class, args);
		
		ProductService ps=ac.getBean(ProductService.class);
		
		Product product=new Product();
		product.setProductId("P006");
		product.setProductName("Mobile");
		product.setPrice(476345);
		
		ps.persist(product);
		
		
		List<Product> prods= ps.listAll();
		
		for(Product prod:prods) {
			System.out.println(prod.getProductId());
			System.out.println(prod.getProductName());
			System.out.println(prod.getPrice());
			System.out.println("----------------------------");
		}
		
	}

}

