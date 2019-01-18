package com.cts;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(SpringBootDataJpaApplication.class, args);
	
		ProductService ps=ac.getBean(ProductService.class);
		
		Product product=new Product();
		product.setProductId("P007");
		product.setProductName("Mouse");
		product.setPrice(7504);
		
		//ps.persist(product);
		
		for(Product prod:ps.listAll()) {
			System.out.println(prod.getProductId());
			System.out.println(prod.getProductName());
			System.out.println(prod.getPrice());
			System.out.println("---------------------------");
		}
		
		System.out.println("---------------------------->");
		
		
		List<Product> cprods=ps.readProductByProductName("Mouse");
		
		for(Product prod:cprods) {
			System.out.println(prod.getProductId());
			System.out.println(prod.getProductName());
			System.out.println(prod.getPrice());
			System.out.println("---------------------------");
		}
		
		
		
	}

}

